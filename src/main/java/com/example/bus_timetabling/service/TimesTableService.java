package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.TimesTableRequestDto;
import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.entities.TimesTable;
import com.example.bus_timetabling.repository.TimesTableRepository;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.StopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TimesTableService {

    private final TimesTableRepository timesTableRepository;
    private final BusRepository busRepository;
    private final StopRepository stopRepository;

    public TimesTableService(TimesTableRepository timesTableRepository,
                             BusRepository busRepository,
                             StopRepository stopRepository) {
        this.timesTableRepository = timesTableRepository;
        this.busRepository = busRepository;
        this.stopRepository = stopRepository;
    }

    @Transactional(readOnly = true)
    public List<TimesTableResponseDto> getAllTimesTables() {
        return timesTableRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TimesTableResponseDto getTimesTableById(Long id) {
        TimesTable timesTable = timesTableRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TimesTable not found with id: " + id));
        return mapToResponseDto(timesTable);
    }

    public TimesTableResponseDto createTimesTable(TimesTableRequestDto requestDto) {
        Bus bus = getBusById(requestDto.getBusId());
        Stop stop = getStopById(requestDto.getStopId());

        TimesTable timesTable = new TimesTable();
        updateTimesTableFromDto(timesTable, requestDto, bus, stop);

        TimesTable savedTimesTable = timesTableRepository.save(timesTable);
        return mapToResponseDto(savedTimesTable);
    }

    public void deleteTimesTable(Long id) {
        if (!timesTableRepository.existsById(id)) {
            throw new IllegalArgumentException("TimesTable not found with id: " + id);
        }
        timesTableRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<TimesTableResponseDto> getTimesTablesByBusId(Long busId) {
        return timesTableRepository.findByBusId(busId)
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TimesTableResponseDto> getTimesTablesByStopId(Long stopId) {
        return timesTableRepository.findByStopId(stopId)
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    public TimesTableResponseDto updateTimesTable(Long id, TimesTableRequestDto requestDto) {
        TimesTable existing = timesTableRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TimesTable not found with id: " + id));

        Bus bus = getBusById(requestDto.getBusId());
        Stop stop = getStopById(requestDto.getStopId());

        updateTimesTableFromDto(existing, requestDto, bus, stop);

        TimesTable updated = timesTableRepository.save(existing);
        return mapToResponseDto(updated);
    }

    private TimesTableResponseDto mapToResponseDto(TimesTable timesTable) {
        TimesTableResponseDto responseDto = new TimesTableResponseDto();
        responseDto.setId(timesTable.getId());
        responseDto.setDepartures(timesTable.getDepartures());
        responseDto.setArrival(timesTable.getArrival());
        responseDto.setBusId(timesTable.getBus().getId());
        responseDto.setBusNumber(timesTable.getBus().getBusNumber());
        responseDto.setStopId(timesTable.getStop().getId());
        responseDto.setStopName(timesTable.getStop().getStopName());
        responseDto.calculateJourneyDuration();
        return responseDto;
    }

    private Bus getBusById(Long busId) {
        return busRepository.findById(busId)
                .orElseThrow(() -> new IllegalArgumentException("Bus not found with id: " + busId));
    }

    private Stop getStopById(Long stopId) {
        return stopRepository.findById(stopId)
                .orElseThrow(() -> new IllegalArgumentException("Stop not found with id: " + stopId));
    }

    private void updateTimesTableFromDto(TimesTable timesTable, TimesTableRequestDto dto, Bus bus, Stop stop) {
        timesTable.setDepartures(dto.getDepartures());
        timesTable.setArrival(dto.getArrival());
        timesTable.setBus(bus);
        timesTable.setStop(stop);
    }
}