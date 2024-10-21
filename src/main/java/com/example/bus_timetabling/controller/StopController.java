package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.StopDto;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.service.StopService;
import org.springframework.http.HttpStatus;
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
    public List<StopDto> findStops() {
        return stopService.findAllStops();
    }

    @GetMapping("/{id}")
    public StopDto findStopDetail(@PathVariable Long id) {
        return stopService.findStopById(id);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<HttpStatus> createStop(@RequestBody StopDto request ) {
        stopService.createStop(request);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateStop(@PathVariable long id, @RequestBody StopDto request ) {
        stopService.updateBus(id, request);

        return ResponseEntity.ok(HttpStatus.OK);

    }
}
