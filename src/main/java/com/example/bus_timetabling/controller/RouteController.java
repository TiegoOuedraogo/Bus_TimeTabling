package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/route")
@CrossOrigin
public class RouteController {

    //constructor injection of Route Service
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public List<RouteResponseDto> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/{route_id}")
    public RouteResponseDto findRouteById(@PathVariable("route_id") Long route_id) {
        return (RouteResponseDto) routeService.findRouteById(route_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRoute(@RequestBody RouteRequestDto routeRequestDto) {
       routeService.createRoute(routeRequestDto);
    }
}