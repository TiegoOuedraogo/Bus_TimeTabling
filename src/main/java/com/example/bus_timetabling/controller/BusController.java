package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.service.BusService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

//    @PostMapping("/{bus-id}")
//    public BusDto findBusById(@PathVariable("student-id") Integer id) {
//        return busService.findBusById(id);
//    }
}
