package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.exception.RouteNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImplementation implements RouteService {
    @Override
    public RouteResponseDto createRoute(RouteRequestDto routeRequestDto) {
        return null;
    }

    @Override
    public List<RouteResponseDto> retrieveAllRoutes() {

        return List.of() ;
    }

    @Override
    public RouteResponseDto findRouteById(Object route_id) throws RouteNotFoundException {
        return null;
    }

    @Override
    public RouteResponseDto deleteRouteById(Object route_id) throws RouteNotFoundException {
        return null;
    }
}
