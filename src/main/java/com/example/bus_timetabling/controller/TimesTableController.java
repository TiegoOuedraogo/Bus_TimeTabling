package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.TimesTableRequestDto;
import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.repository.TimesTableRepository;
import com.example.bus_timetabling.service.TimesTableService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/timetables")
public class TimesTableController {

    private final TimesTableService timesTableService;
    private final TimesTableRepository timesTableRepository;

    public TimesTableController(TimesTableService timesTableService, TimesTableRepository timesTableRepository) {
        this.timesTableService = timesTableService;
        this.timesTableRepository = timesTableRepository;
    }

    @PostMapping("/api/timetables")
    public ResponseEntity<TimesTableResponseDto> createTimesTable(@Valid @RequestBody TimesTableRequestDto dto) {
        TimesTableResponseDto response = timesTableService.createTimesTable(dto);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public TimesTableResponseDto updateTimesTable(
            @PathVariable Long id, @Valid @RequestBody TimesTableRequestDto requestDto) {
        return timesTableService.updateTimesTable(id, requestDto);
    }

    @GetMapping
    public List<TimesTableResponseDto> getAllTimesTables() {
        return timesTableService.getAllTimesTables();
    }

    @GetMapping("/api/timetables/{id}")
    public ResponseEntity<TimesTableResponseDto> getTimesTableById(@PathVariable Long id) {
        TimesTableResponseDto response = timesTableService.getTimesTableById(id);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public void deleteTimesTable(@PathVariable Long id) {
        if (!timesTableRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TimesTable not found with id: " + id);
        }
        timesTableRepository.deleteById(id);
    }


    @GetMapping("/bus/{busId}")
    public List<TimesTableResponseDto> getTimesTablesByBusId(@PathVariable Long busId) {
        return timesTableService.getTimesTablesByBusId(busId);
    }

    @GetMapping("/stop/{stopId}")
    public List<TimesTableResponseDto> getTimesTablesByStopId(@PathVariable Long stopId) {
        return timesTableService.getTimesTablesByStopId(stopId);
    }

}

