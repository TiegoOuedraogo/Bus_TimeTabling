package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.CustomDto;
import com.example.bus_timetabling.dto.TimetableRequestDto;
import com.example.bus_timetabling.dto.TimetableResponseDto;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.entities.Timetable;
import com.example.bus_timetabling.exception.ResourceNotFoundException;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.StopRepository;
import com.example.bus_timetabling.repository.TimetableRepository;
import com.example.bus_timetabling.service.TimetableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class TimetableServiceImplementation implements TimetableService {

    private final TimetableRepository timetableRepository;
    private final StopRepository stopRepository;
    private final BusRepository busRepository;

    public TimetableServiceImplementation(TimetableRepository timetableRepository, StopRepository stopRepository, BusRepository busRepository) {
        this.timetableRepository = timetableRepository;
        this.stopRepository = stopRepository;
        this.busRepository = busRepository;
    }

    @Override
    public List<TimetableResponseDto> getAllTimetables() {
        return timetableRepository.findAll().stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public TimetableResponseDto getTimetableById(Long id) throws ResourceNotFoundException {
        Timetable timetable = timetableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Timetable not found with id " + id));
        return toResponseDto(timetable);
    }

    @Override
    public TimetableResponseDto createTimetable(TimetableRequestDto requestDto) {
        Timetable timetable = new Timetable();
        timetable.setDeparture(requestDto.getDeparture());
        timetable.setArrival(requestDto.getArrival());

        Bus bus = busRepository.findById(requestDto.getBusId())
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found with id " + requestDto.getBusId()));
        Stop stop = stopRepository.findById(requestDto.getStopId())
                .orElseThrow(() -> new ResourceNotFoundException("Stop not found with id " + requestDto.getStopId()));

        timetable.setBus(bus);
        timetable.setStop(stop);

        Timetable savedTimetable = timetableRepository.save(timetable);
        return toResponseDto(savedTimetable);
    }

    @Override
    public TimetableResponseDto updateTimetable(Long id, TimetableRequestDto requestDto) throws ResourceNotFoundException {
        Timetable timetable = timetableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Timetable not found with id " + id));

        timetable.setDeparture(requestDto.getDeparture());
        timetable.setArrival(requestDto.getArrival());

        Bus bus = busRepository.findById(requestDto.getBusId())
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found with id " + requestDto.getBusId()));
        Stop stop = stopRepository.findById(requestDto.getStopId())
                .orElseThrow(() -> new ResourceNotFoundException("Stop not found with id " + requestDto.getStopId()));

        timetable.setBus(bus);
        timetable.setStop(stop);

        Timetable updatedTimetable = timetableRepository.save(timetable);
        return toResponseDto(updatedTimetable);
    }

    @Override
    public void deleteTimetable(Long id) throws ResourceNotFoundException {
        if (!timetableRepository.existsById(id)) {
            throw new ResourceNotFoundException("Timetable not found with id " + id);
        }
        timetableRepository.deleteById(id);
    }

    @Override
    public CustomDto findNextBusForRoute(Long stopId, LocalTime currentTime) {
        Optional<Timetable> nextBus = timetableRepository.findNextBusForRoute(stopId, currentTime);
        if (nextBus.isPresent()) {
            Timetable timetable = nextBus.get();
            return new CustomDto(timetable.getBus().getBusNumber(), timetable.getArrival());
        } else {
            throw new ResourceNotFoundException("No upcoming bus found for stop:  " + stopRepository.findById(stopId).get().getStopName() );
        }
    }

    @Override
    public List<CustomDto> findNextThreeBusesAtStop(Long stopId, LocalTime currentTime) {
        List<Timetable> nextBuses = timetableRepository.findNextThreeBusesAtStop(stopId, currentTime);
        return nextBuses.stream()
                .map(timetable -> new CustomDto(
                        timetable.getBus().getBusNumber(),
                        timetable.getArrival()))
                .collect(Collectors.toList());
    }

    @Override
    public Duration calculateTravelTime(Long stopXId, Long stopYId) {
        Stop stopX = stopRepository.findById(stopXId)
                .orElseThrow(() -> new ResourceNotFoundException("Stop not found with id " + stopXId));
        Stop stopY = stopRepository.findById(stopYId)
                .orElseThrow(() -> new ResourceNotFoundException("Stop not found with id " + stopYId));

        List<Timetable> schedules = timetableRepository.findSchedulesForStops(stopX, stopY);

        if (schedules.size() < 2) {
            throw new ResourceNotFoundException("Not enough schedules to calculate travel time between stops");
        }

        Timetable firstSchedule = schedules.get(0);
        Timetable lastSchedule = schedules.get(schedules.size() - 1);

        return Duration.between(firstSchedule.getDeparture(), lastSchedule.getArrival()).minus(Duration.ofHours(7));
    }

    private TimetableResponseDto toResponseDto(Timetable timetable) {
        return new TimetableResponseDto(
                timetable.getId(),
                timetable.getBus().getId(),
                timetable.getStop().getId(),
                timetable.getDeparture(),
                timetable.getArrival()
        );
    }
}
