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
//public class TimesTableController {
//
//    @Autowired
//    private TimesTableServiceImpl timesTableService;
//
//    public TimesTableController(TimesTableServiceImpl timesTableService) {
//        this.timesTableService = timesTableService;
//    }
//
//    @PostMapping
//    public TimesTableResponseDto createTimesTable(@RequestBody TimesTableResponseDto requestDto) {
//        return timesTableService.createTimesTable(requestDto);
//    }
//
//    @PutMapping("/{id}")
//    public TimesTableResponseDto updateTimesTable(
//            @PathVariable Long id, @RequestBody TimesTableResponseDto requestDto) {
//        return timesTableService.updateTimesTable(id, requestDto);
//    }
//
//    @GetMapping
//    public List<TimesTableResponseDto> getAllTimesTables() {
//        return timesTableService.getAllTimesTables();
//    }
//
//    @GetMapping("/{id}")
//    public TimesTableResponseDto getTimesTableById(@PathVariable Long id) {
//        return timesTableService.getTimesTableById(id);
//    }
//
//    @GetMapping("/next-bus/{stopId}")
//    public CustomDto getNextBusForRoute(@PathVariable Long stopId) {
//        LocalTime currentTime = LocalTime.now();
//        CustomDto nextBus = timesTableService.findNextBusForRoute(stopId, currentTime);
//        return nextBus;
//    }
//
//    @GetMapping("buses/{stopId}")
//    public List<CustomDto> get3buses(@PathVariable Long stopId) {
//        LocalTime time = LocalTime.now();
//        return timesTableService.findNextThreeBusesAtStop(stopId, time);
//    }
//
//    @GetMapping("buses/betweenstops")
//    public String timeBetween2stops(@RequestParam Long stopX, @RequestParam Long stopY) {
//        Duration travelTime = timesTableService.calculateTravelTime(stopX, stopY);
//        return "Travel time: " + travelTime.toHours() + " hours " + travelTime.toMinutesPart() + " minutes";
//    }
//
//}
//


public class TimesTableController {

    private final TimetableService timetableService;

    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @PostMapping
    public ResponseEntity<TimetableResponseDto> createTimetable(@RequestBody @Valid TimetableRequestDto requestDto) {
        TimetableResponseDto createdTimetable = timetableService.createTimetable(requestDto);
        return new ResponseEntity<>(createdTimetable, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimetableResponseDto> updateTimetable(@PathVariable Long id, @RequestBody @Valid TimetableRequestDto requestDto) {
        TimetableResponseDto updatedTimetable = timetableService.updateTimetable(id, requestDto);
        return ResponseEntity.ok(updatedTimetable);
    }

    @GetMapping
    public ResponseEntity<List<TimetableResponseDto>> getAllTimetables() {
        List<TimetableResponseDto> timetables = timetableService.getAllTimetables();
        return ResponseEntity.ok(timetables);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimetableResponseDto> getTimetableById(@PathVariable Long id) {
        TimetableResponseDto timetable = timetableService.getTimetableById(id);
        return ResponseEntity.ok(timetable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimetable(@PathVariable Long id) {
        timetableService.deleteTimetable(id);
        return ResponseEntity.noContent().build();
    }

    // Custom endpoints
    @GetMapping("/next-bus/{stopId}")
    public ResponseEntity<CustomDto> getNextBusForRoute(@PathVariable Long stopId) {
        LocalTime currentTime = LocalTime.now();
        CustomDto nextBus = timetableService.findNextBusForRoute(stopId, currentTime);
        return ResponseEntity.ok(nextBus);
    }

    @GetMapping("/buses/{stopId}")
    public ResponseEntity<List<CustomDto>> getNextThreeBuses(@PathVariable Long stopId) {
        LocalTime currentTime = LocalTime.now();
        List<CustomDto> buses = timetableService.findNextThreeBusesAtStop(stopId, currentTime);
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/buses/betweenstops")
    public ResponseEntity<String> getTimeBetweenStops(@RequestParam Long stopX, @RequestParam Long stopY) {
        Duration travelTime = timetableService.calculateTravelTime(stopX, stopY);
        String message = String.format("Travel time: %d hours %d minutes", travelTime.toHours(), travelTime.toMinutesPart());
        return ResponseEntity.ok(message);
    }
}