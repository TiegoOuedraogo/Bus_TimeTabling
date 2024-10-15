package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Stop;

import java.util.List;

public record RouteResponseDto(
        Long route_id,
        String route_name,
        String origin,
        String destination,
        Double distance,
        List <StopResponseDto> stops,
        List<BusResponseDto> buses
) { }
