package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.exception.ResourceNotFoundException;
import com.example.bus_timetabling.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/routes")
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
    public ResponseEntity<RouteResponseDto> findRouteById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        RouteResponseDto route = routeService.findRouteById(id);
        return ResponseEntity.ok(route);
    }

    @PostMapping
    public ResponseEntity<RouteResponseDto> createRoute(@RequestBody @Valid RouteRequestDto routeRequestDto) {
        RouteResponseDto createdRoute = routeService.createRoute(routeRequestDto);
        return new ResponseEntity<>(createdRoute, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RouteResponseDto> updateRoute(@PathVariable Long id, @RequestBody @Valid RouteRequestDto routeRequestDto) throws ResourceNotFoundException {
        RouteResponseDto updatedRoute = routeService.updateRoute(id, routeRequestDto);
        return ResponseEntity.ok(updatedRoute);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id) throws ResourceNotFoundException {
        routeService.deleteRoute(id);
        return ResponseEntity.noContent().build();
    }
}
