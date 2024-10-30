package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/route")
@CrossOrigin
//public class RouteController {
//
//    //constructor injection of Route Service
//    private final RouteService routeService;
//
//    public RouteController(RouteService routeService) {
//        this.routeService = routeService;
//    }
//
//    @GetMapping
//    public List<RouteResponseDto> getAllRoutes() {
//        return routeService.getAllRoutes();
//    }
//
//    @GetMapping("/{route_id}")
//    public RouteResponseDto findRouteById(@PathVariable("route_id") Long route_id) {
//        return (RouteResponseDto) routeService.findRouteById(route_id);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createRoute(@RequestBody RouteRequestDto routeRequestDto) {
//       routeService.createRoute(routeRequestDto);
//    }
//}


public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public ResponseEntity<List<RouteResponseDto>> getAllRoutes() {
        List<RouteResponseDto> routes = routeService.getAllRoutes();
        return ResponseEntity.ok(routes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteResponseDto> findRouteById(@PathVariable("id") Long id) {
        RouteResponseDto route = routeService.findRouteById(id);
        return ResponseEntity.ok(route);
    }

    @PostMapping
    public ResponseEntity<RouteResponseDto> createRoute(@RequestBody @Valid RouteRequestDto routeRequestDto) {
        RouteResponseDto createdRoute = routeService.createRoute(routeRequestDto);
        return new ResponseEntity<>(createdRoute, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RouteResponseDto> updateRoute(@PathVariable Long id, @RequestBody @Valid RouteRequestDto routeRequestDto) {
        RouteResponseDto updatedRoute = routeService.updateRoute(id, routeRequestDto);
        return ResponseEntity.ok(updatedRoute);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
        return ResponseEntity.noContent().build();
    }
}

