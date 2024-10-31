package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteStopRequestDto;
import com.example.bus_timetabling.dto.RouteStopResponseDto;
import com.example.bus_timetabling.exception.ResourceNotFoundException;

import java.util.List;

public interface RouteStopService {

    List<RouteStopResponseDto> getAllRouteStops();

    RouteStopResponseDto createRouteStop(RouteStopRequestDto requestDto) throws ResourceNotFoundException;

    void deleteRouteStop(Long routeId, Long stopId) throws ResourceNotFoundException;
}
