package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.RouteStopRequestDto;
import com.example.bus_timetabling.dto.RouteStopResponseDto;
import com.example.bus_timetabling.service.RouteStopService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/route-stop-schedules")
//public class RouteStopController {
//    @Autowired
//    private RouteStopServiceImpl routeStopScheduleService;
//
//    @GetMapping
//    public List<RouteStopResponseDto> getAllRouteStopSchedules() {
//        return routeStopScheduleService.getAllRouteStopSchedules();
//    }
//
//    @GetMapping("/{id}")
//    public RouteStopResponseDto getRouteStopScheduleById(@PathVariable Long id) {
//        return routeStopScheduleService.getRouteStopScheduleById(id);
//    }
//}

public class RouteStopController {

    private final RouteStopService routeStopService;

    public RouteStopController(RouteStopService routeStopService) {
        this.routeStopService = routeStopService;
    }

    @GetMapping
    public ResponseEntity<List<RouteStopResponseDto>> getAllRouteStops() {
        List<RouteStopResponseDto> routeStops = routeStopService.getAllRouteStops();
        return ResponseEntity.ok(routeStops);
    }

    @PostMapping
    public ResponseEntity<RouteStopResponseDto> createRouteStop(@RequestBody @Valid RouteStopRequestDto requestDto) {
        RouteStopResponseDto createdRouteStop = routeStopService.createRouteStop(requestDto);
        return new ResponseEntity<>(createdRouteStop, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRouteStop(@RequestParam Long routeId, @RequestParam Long stopId) {
        routeStopService.deleteRouteStop(routeId, stopId);
        return ResponseEntity.noContent().build();
    }
}