package com.example.bus_timetabling.controller;
import com.example.bus_timetabling.dto.RouteDto;
//import com.example.bus_timetabling.dto.RouteRequestDto;
//import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/route")
@CrossOrigin
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }
    @GetMapping


    public List<RouteResponseDto> retrieveAllRoutes () {
        return routeService.retrieveAllRoutes();
    }

    @GetMapping("/{id}")
    public RouteResponseDto findRouteById (@PathVariable Long id){
        return routeService.findRouteById(id);
    }

    @DeleteMapping("/routeId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <HttpStatus> deleteRouteById (@PathVariable Long id){
        routeService.deleteRouteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createRoute(RouteDto routeDto){
        routeService.createRoute(routeDto);
        return ResponseEntity.ok("Route deleted successfully");
    }
}
