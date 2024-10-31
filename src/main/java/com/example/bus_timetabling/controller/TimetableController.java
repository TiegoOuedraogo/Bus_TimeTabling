package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.CustomDto;
import com.example.bus_timetabling.dto.TimetableRequestDto;
import com.example.bus_timetabling.dto.TimetableResponseDto;
import com.example.bus_timetabling.exception.ResourceNotFoundException;
import com.example.bus_timetabling.service.TimetableService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/timetables")
public class TimetableController {

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
    public ResponseEntity<TimetableResponseDto> updateTimetable(@PathVariable Long id, @RequestBody @Valid TimetableRequestDto requestDto) throws ResourceNotFoundException {
        TimetableResponseDto updatedTimetable = timetableService.updateTimetable(id, requestDto);
        return ResponseEntity.ok(updatedTimetable);
    }

    @GetMapping
    public ResponseEntity<List<TimetableResponseDto>> getAllTimetables() {
        List<TimetableResponseDto> timetables = timetableService.getAllTimetables();
        return ResponseEntity.ok(timetables);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimetableResponseDto> getTimetableById(@PathVariable Long id) throws ResourceNotFoundException {
        TimetableResponseDto timetable = timetableService.getTimetableById(id);
        return ResponseEntity.ok(timetable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimetable(@PathVariable Long id) throws ResourceNotFoundException {
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
