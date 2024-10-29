package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.CustomDto;
import com.example.bus_timetabling.dto.TimesTableRequestDto;
import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.entities.TimesTable;
import com.example.bus_timetabling.service.serviceImpl.TimesTableServiceImpl;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/next-bus/{stopId}")
    public CustomDto getNextBusForRoute(@PathVariable Long stopId) {
        LocalTime currentTime = LocalTime.now();
        CustomDto nextBus = timesTableService.findNextBusForRoute(stopId, currentTime);
        return nextBus;
    }

    @GetMapping("buses/{stopId}")
    public List<CustomDto> get3buses(@PathVariable Long stopId) {
        LocalTime time = LocalTime.now();
        return timesTableService.findNextThreeBusesAtStop(stopId, time);
    }

    @GetMapping("buses/betweenstops")
    public String timeBetween2stops(@RequestParam Long stopX, @RequestParam Long stopY) {
        Duration travelTime = timesTableService.calculateTravelTime(stopX, stopY);
        return "Travel time: " + travelTime.toHours() + " hours " + travelTime.toMinutesPart() + " minutes";
    }

}

