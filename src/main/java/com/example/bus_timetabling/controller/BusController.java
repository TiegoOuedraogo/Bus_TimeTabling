package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.service.BusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping("/bus/{id}")
    public BusResponseDto findBusById(@PathVariable("student-id") Long id) {
        return busService.findBusById(id);
    }

    @GetMapping("/bus/{busNumber}")
    public List<BusResponseDto> findBusByNumber(@PathVariable("busNumber") String busNumber) {
        return busService.findBusByNumber(busNumber);
    }

    @GetMapping("/bus")
    public List<BusResponseDto> getAllBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("/bus/{routeId}")
    public List<BusResponseDto> findBusByRouteId(@PathVariable("routeId") Long routeId) {
        return busService.findBusByRouteId(routeId);
    }

    @GetMapping("/bus/{stopId}")
    public List<BusResponseDto> findBusByStopId(@PathVariable("stopId") Long stopId) {
        return busService.findBusByStopId(stopId);
    }


}
