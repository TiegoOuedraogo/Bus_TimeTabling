package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.service.BusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/buses")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping("/{id}")
    public BusDto findBusById(@PathVariable("id") Long id) {
        return busService.findBusById(id);
    }

    @GetMapping("/BusNumber/{busNumber}")
    public List<BusDto> findBusByNumber(@PathVariable("busNumber") String busNumber) {
        return busService.findBusByNumber(busNumber);
    }

    @GetMapping
    public List<BusDto> getAllBuses() {
        return busService.getAllBuses();
    }

}
