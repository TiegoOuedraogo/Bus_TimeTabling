package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.exception.ResourceNotFoundException;

import java.util.List;

public interface RouteService {

    RouteResponseDto createRoute(RouteRequestDto routeRequestDto);

    List<RouteResponseDto> getAllRoutes();

    RouteResponseDto findRouteById(Long routeId) throws ResourceNotFoundException;

    RouteResponseDto updateRoute(Long routeId, RouteRequestDto routeRequestDto) throws ResourceNotFoundException;

    void deleteRoute(Long routeId) throws ResourceNotFoundException;
}
