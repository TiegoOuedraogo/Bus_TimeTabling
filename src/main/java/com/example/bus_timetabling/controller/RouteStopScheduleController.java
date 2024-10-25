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

    public RouteStopScheduleController(RouteStopScheduleServiceImpl routeStopScheduleService) {
        this.routeStopScheduleService = routeStopScheduleService;
    }

    @GetMapping
    public List<RouteStopScheduleResponseDto> getAllRouteStopSchedules() {
        return routeStopScheduleService.getAllRouteStopSchedules();
    }

//    @PostMapping
//    public RouteStopScheduleResponseDto addRouteStopSchedule(@RequestBody RouteStopScheduleResponseDto routeStopScheduleResponseDto) {
//        return routeStopScheduleService.addRouteStopSchedule(routeStopScheduleResponseDto);
//    }
    @GetMapping("/{id}")
    public RouteStopScheduleResponseDto getRouteStopScheduleById(@PathVariable Long id) {
        return routeStopScheduleService.getRouteStopScheduleById(id);
    }
//    @PutMapping("/{id}")
//    public RouteStopScheduleResponseDto updateRouteStopSchedule(@PathVariable Long id, @RequestBody RouteStopScheduleResponseDto routeStopScheduleResponseDto) {
//        return routeStopScheduleService.updateRouteStopSchedule(id, routeStopScheduleResponseDto);
//    }
//    @DeleteMapping("/{id}")
//    public void deleteRouteStopSchedule(@PathVariable Long id) {
//        routeStopScheduleService.deleteRouteStopSchedule(id);
//    }

}

