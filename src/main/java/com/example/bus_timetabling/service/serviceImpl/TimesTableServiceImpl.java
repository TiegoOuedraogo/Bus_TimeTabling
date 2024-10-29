package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.CustomDto;
import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.TimesTable;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.StopRepository;
import com.example.bus_timetabling.repository.TimesTableRepository;
import com.example.bus_timetabling.service.TimeTableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class TimesTableServiceImpl implements TimeTableService {

    private final TimesTableRepository timesTableRepository;

    private final StopRepository stopRepository;

    private final BusRepository busRepository;

    public TimesTableServiceImpl(TimesTableRepository timesTableRepository, StopRepository stopRepository, BusRepository busRepository) {
        this.timesTableRepository = timesTableRepository;

        this.stopRepository = stopRepository;
        this.busRepository = busRepository;
    }



    @Override
    public List<TimesTableResponseDto> getAllTimesTables() {
        return timesTableRepository.findAll().stream()
               .map(this::mapTimesTableResponseDto)
               .collect(Collectors.toList());
    }

    @Override
    public TimesTableResponseDto getTimesTableById(Long id) {
        TimesTable timesTable = timesTableRepository.findById(id).orElseThrow(() -> new RuntimeException("Times Table not found"));
        return mapTimesTableResponseDto(timesTable);
    }


    @Override
    public TimesTableResponseDto createTimesTable(TimesTableResponseDto requestDto) {
        TimesTable timesTable = new TimesTable();
        timesTable.setDeparture(requestDto.getDeparture());
        timesTable.setArrival(requestDto.getArrival());
        timesTable.setFromStop(stopRepository.findById(requestDto.getFromStopId())
                .orElseThrow(() -> new RuntimeException("From Stop not found")));
        timesTable.setToStop(stopRepository.findById(requestDto.getToStopId())
                .orElseThrow(() -> new RuntimeException("To Stop not found")));
        timesTableRepository.save(timesTable);
        return mapTimesTableResponseDto(timesTable);
    }

    @Override
    public TimesTableResponseDto updateTimesTable(Long id, TimesTableResponseDto requestDto) {
        TimesTable timesTable = timesTableRepository.findById(id).orElseThrow(() -> new RuntimeException("Times Table not found"));
        timesTable.setDeparture(requestDto.getDeparture());
        timesTable.setArrival(requestDto.getArrival());
        timesTableRepository.save(timesTable);
        return mapTimesTableResponseDto(timesTable);
    }

    @Override
    public List<CustomDto> findNextThreeBusesAtStop(Long stopId, LocalTime currentTime) {
        List<TimesTable> nextBuses = timesTableRepository.findNextThreeBusesAtStop(stopId, currentTime);
        List<CustomDto> buses = new ArrayList<>();
        for(int i = 0; i < nextBuses.size(); i++) {
            CustomDto customDto = new CustomDto();
            customDto.setBusNumber(busRepository.findById(nextBuses.get(i).getBus().getId()).orElseThrow(() -> new RuntimeException("Bus not found")).getBusNumber());
            customDto.setArrivalTime(nextBuses.get(i).getArrival());
            buses.add(customDto);
        }
        return buses;
    }


    public CustomDto findNextBusForRoute(Long stopId, LocalTime currentTime) {
        return new CustomDto(timesTableRepository.findNextBusForRoute(stopId, currentTime).get().getBus().getBusNumber(),timesTableRepository.findNextBusForRoute(stopId, currentTime).get().getArrival());
    }

    @Override
    public Duration calculateTravelTime(Long stopX, Long stopY) {
        List<TimesTable> schedules = timesTableRepository.findSchedulesForStops(
                stopRepository.findById(stopX).orElseThrow(() -> new RuntimeException("Stop X not found")),
                stopRepository.findById(stopY).orElseThrow(() -> new RuntimeException("Stop Y not found")));

        if (schedules.isEmpty()) {
            return null;
        }

        TimesTable firstSchedule = schedules.get(0);
        TimesTable lastSchedule = schedules.get(schedules.size() - 1);

        Duration duration = Duration.between(firstSchedule.getDeparture(), lastSchedule.getArrival());
        return duration;

    }

    private TimesTableResponseDto mapTimesTableResponseDto(TimesTable timesTable) {
        System.out.println("Mapping TimesTable: " + timesTable);
        return TimesTableResponseDto.builder()
                .id(timesTable.getId())
                .departure(timesTable.getDeparture())
                .arrival(timesTable.getArrival())
                .fromStopId(timesTable.getFromStop().getId())
                .toStopId(timesTable.getToStop().getId())
                .busId(timesTable.getBus() != null ? timesTable.getBus().getId() : null)
                .build();
    }

}
