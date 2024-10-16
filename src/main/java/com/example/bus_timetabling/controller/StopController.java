package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.StopDto;
import com.example.bus_timetabling.dto.StopRequestDto;
import com.example.bus_timetabling.dto.StopResponseDto;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.service.StopService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/stops")
public class StopController {

    private final StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping("")
    public List<StopResponseDto> findStops() {
        return stopService.findAllStops();
    }

    @GetMapping("/{id}")
    public StopResponseDto findStopDetail(@PathVariable Long id) {
        return stopService.findStopById(id);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<StopResponseDto> createStop(@RequestBody StopRequestDto request ) {
        StopDto stopDto = new StopDto();
        stopDto.setStopName(request.getStopName());
        stopDto.setRoute(request.getRoute());
        stopDto.setTimesTables(request.getTimesTables());

        return ResponseEntity.ok(stopService.createStop(stopDto));

    }
}
