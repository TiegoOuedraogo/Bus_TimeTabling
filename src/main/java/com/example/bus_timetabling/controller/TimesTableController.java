package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.service.serviceImpl.TimesTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/timetables")
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

