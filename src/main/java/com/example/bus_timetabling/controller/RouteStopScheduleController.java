package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.RouteStopScheduleResponseDto;
import com.example.bus_timetabling.service.serviceImpl.RouteStopScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/route-stop-schedules")
public class RouteStopScheduleController {
    @Autowired
    private RouteStopScheduleServiceImpl routeStopScheduleService;

    @GetMapping
    public List<RouteStopScheduleResponseDto> getAllRouteStopSchedules() {
        return routeStopScheduleService.getAllRouteStopSchedules();
    }

    @GetMapping("/{id}")
    public RouteStopScheduleResponseDto getRouteStopScheduleById(@PathVariable Long id) {
        return routeStopScheduleService.getRouteStopScheduleById(id);
    }
}
