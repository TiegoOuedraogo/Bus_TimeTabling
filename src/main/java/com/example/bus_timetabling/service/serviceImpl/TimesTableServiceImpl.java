package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.entities.TimesTable;
import com.example.bus_timetabling.repository.TimesTableRepository;
import com.example.bus_timetabling.service.TimeTableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class TimesTableServiceImpl implements TimeTableService {

    private final TimesTableRepository timesTableRepository;


    public TimesTableServiceImpl(TimesTableRepository timesTableRepository) {
        this.timesTableRepository = timesTableRepository;

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
               .build();
    }
}

