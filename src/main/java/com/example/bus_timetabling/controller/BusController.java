package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.service.serviceImpl.BusService;
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

//    @GetMapping("/{id}")
//    public BusDto findBusById(@PathVariable("id") Long id) {
//        return busService.findBusById(id);
//    }
//
//    @GetMapping("/BusNumber/{busNumber}")
//    public List<BusDto> findBusByNumber(@PathVariable("busNumber") String busNumber) {
//        return busService.findBusByNumber(busNumber);
//    }
//
//    @GetMapping
//    public List<BusDto> getAllBuses() {
//        return busService.getAllBuses();
//    }

}
