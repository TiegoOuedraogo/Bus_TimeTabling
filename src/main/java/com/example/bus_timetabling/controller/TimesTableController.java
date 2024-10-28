package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.TimesTableRequestDto;
import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.service.serviceImpl.TimesTableServiceImpl;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;

@CrossOrigin
@RestController
@RequestMapping("/api/timetables")
@JsonFormat
public class TimesTableController {

    @Autowired
    private TimesTableServiceImpl timesTableService;

    public TimesTableController(TimesTableServiceImpl timesTableService) {
        this.timesTableService = timesTableService;
    }

    @PostMapping
    public TimesTableResponseDto createTimesTable(@RequestBody TimesTableResponseDto requestDto) {
        return timesTableService.createTimesTable(requestDto);
    }

    @PutMapping("/{id}")
    public TimesTableResponseDto updateTimesTable(
            @PathVariable Long id, @RequestBody TimesTableResponseDto requestDto) {
        return timesTableService.updateTimesTable(id, requestDto);
    }

    @GetMapping
    public List<TimesTableResponseDto> getAllTimesTables() {
        return timesTableService.getAllTimesTables();
    }

    @GetMapping("/{id}")
    public TimesTableResponseDto getTimesTableById(@PathVariable Long id) {
        return timesTableService.getTimesTableById(id);
    }

    @GetMapping("buses/{stopId}")
    public List<TimesTableResponseDto> get3buses(@PathVariable Long stopId) {
        LocalTime time = LocalTime.of(07,50);
        return timesTableService.findNextThreeBusesAtStop(stopId, time);
    }

//    @DeleteMapping("/{id}")
//    public void deleteTimesTable(@PathVariable Long id) {
//        timesTableService.deleteTimesTable(id);
//    }

//    @GetMapping("/bus/{busId}")
//    public List<TimesTableResponseDto> getTimesTablesByBusId(@PathVariable Long busId) {
//        return timesTableService.getTimesTablesByBusId(busId);
//    }
//
//    @GetMapping("/stop/{stopId}")
//    public List<TimesTableResponseDto> getTimesTablesByStopId(@PathVariable Long stopId) {
//        return timesTableService.getTimesTablesByStopId(stopId);
//    }
}

