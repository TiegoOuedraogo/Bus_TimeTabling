package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.entities.TimesTable;
import com.example.bus_timetabling.repository.StopRepository;
import com.example.bus_timetabling.repository.TimesTableRepository;
import com.example.bus_timetabling.service.TimeTableService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class TimesTableServiceImpl implements TimeTableService {

    private final TimesTableRepository timesTableRepository;

    private final StopRepository stopRepository;

    public TimesTableServiceImpl(TimesTableRepository timesTableRepository, StopRepository stopRepository) {
        this.timesTableRepository = timesTableRepository;

        this.stopRepository = stopRepository;
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
    public List<TimesTableResponseDto> findNextThreeBusesAtStop(Long stopId, LocalTime currentTime) {
        List<TimesTable> nextBuses = timesTableRepository.findNextThreeBusesAtStop(stopId, currentTime);
        return nextBuses.stream()
                .map(this::mapTimesTableResponseDto)
                .collect(Collectors.toList());
    }

    private TimesTableResponseDto mapTimesTableResponseDto(TimesTable timesTable) {
        return TimesTableResponseDto.builder()
                .id(timesTable.getId())
                .departure(timesTable.getDeparture())
                .arrival(timesTable.getArrival())
                .fromStopId(timesTable.getFromStop() != null ? timesTable.getFromStop().getId() : null)
                .toStopId(timesTable.getToStop() != null ? timesTable.getToStop().getId() : null)
                .build();
    }

}

