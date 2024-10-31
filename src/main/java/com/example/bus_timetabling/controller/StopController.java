package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.StopRequestDto;
import com.example.bus_timetabling.dto.StopResponseDto;
import com.example.bus_timetabling.exception.ResourceNotFoundException;
import com.example.bus_timetabling.service.StopService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/stops")
@CrossOrigin
public class StopController {

    private final StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping
    public ResponseEntity<List<StopResponseDto>> getAllStops() {
        List<StopResponseDto> stops = stopService.findAllStops();
        return ResponseEntity.ok(stops);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StopResponseDto> findStopById(@PathVariable Long id) throws ResourceNotFoundException {
        StopResponseDto stop = stopService.findByStopId(id);
        return ResponseEntity.ok(stop);
    }

    @GetMapping("/stopname/{stopName}")
    public ResponseEntity<StopResponseDto> findStopByName(@PathVariable String stopName) throws ResourceNotFoundException {
        StopResponseDto stop = stopService.findByStopName(stopName);
        return ResponseEntity.ok(stop);
    }

    @PostMapping
    public ResponseEntity<StopResponseDto> createStop(@RequestBody @Valid StopRequestDto requestDto) {
        StopResponseDto createdStop = stopService.createStop(requestDto);
        return new ResponseEntity<>(createdStop, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StopResponseDto> updateStop(@PathVariable Long id, @RequestBody @Valid StopRequestDto requestDto) throws ResourceNotFoundException {
        StopResponseDto updatedStop = stopService.updateStop(id, requestDto);
        return ResponseEntity.ok(updatedStop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStop(@PathVariable Long id) throws ResourceNotFoundException {
        stopService.deleteStop(id);
        return ResponseEntity.noContent().build();
    }
}
