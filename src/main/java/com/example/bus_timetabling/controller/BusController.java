package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.service.serviceImpl.BusServiceImplementation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/buses")
public class BusController {

    private final BusServiceImplementation busService;

    public BusController(BusServiceImplementation busService) {
        this.busService = busService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusDto> findBusById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(busService.findBusById(id));
    }

    @GetMapping("/BusNumber/{busNumber}")
    public List<BusDto> findBusByNumber(@PathVariable("busNumber") String busNumber) {
        return busService.findByBusNumber(busNumber);
    }

    @GetMapping
    public List<BusDto> getAllBuses() {
        return busService.getAllBuses();
    }

}
