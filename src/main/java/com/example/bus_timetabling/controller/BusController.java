package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.*;
import com.example.bus_timetabling.exception.ResourceNotFoundException;
import com.example.bus_timetabling.service.BusService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/buses")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusResponseDto> findBusById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        BusResponseDto bus = busService.findBusById(id);
        return ResponseEntity.ok(bus);
    }

    @GetMapping("/busNumber/{busNumber}")
    public ResponseEntity<List<BusResponseDto>> findBusByNumber(@PathVariable("busNumber") String busNumber) {
        List<BusResponseDto> buses = busService.findByBusNumber(busNumber);
        return ResponseEntity.ok(buses);
    }

    @GetMapping
    public ResponseEntity<List<BusResponseDto>> getAllBuses() {
        List<BusResponseDto> buses = busService.getAllBuses();
        return ResponseEntity.ok(buses);
    }

    @PostMapping
    public ResponseEntity<BusResponseDto> createBus(@RequestBody @Valid BusRequestDto busRequestDto) {
        BusResponseDto createdBus = busService.createBus(busRequestDto);
        return new ResponseEntity<>(createdBus, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusResponseDto> updateBus(@PathVariable Long id, @RequestBody @Valid BusRequestDto busRequestDto) throws ResourceNotFoundException {
        BusResponseDto updatedBus = busService.updateBus(id, busRequestDto);
        return ResponseEntity.ok(updatedBus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long id) throws ResourceNotFoundException {
        busService.deleteBus(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/route-stops")
    public ResponseEntity<RouteWithStopsDto> getRouteWithStopsByBusId(@PathVariable("id") Long id) throws ResourceNotFoundException {
        RouteWithStopsDto routeWithStops = busService.getRouteWithStopsByBusId(id);
        return ResponseEntity.ok(routeWithStops);
    }
}
