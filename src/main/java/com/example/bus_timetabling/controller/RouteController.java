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
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }
    @GetMapping
    public List<RouteDto> retrieveAllRoutes (){
        return routeService.retrieveAllRoutes();

    }
//    @GetMapping ("/route_id")
    @GetMapping("/{id}")
    public RouteDto findRouteById (@PathVariable Long id){

        return routeService.findRouteById(id);
    }

//    @GetMapping("/route_id")
    @DeleteMapping("/{id}")
    public RouteDto deleteRouteById (@PathVariable Long id){
        return routeService.deleteRouteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HttpStatus> createRoute(RouteDto routeDto){
        routeService.createRoute(routeDto);
        return new ResponseEntity<> (HttpStatus.OK);
    }
}
