package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Stop;

import java.util.List;

public record RouteDto(
        Long route_id,
        String route_name,
        String origin,
        String destination,
        Double distance,
        List<Bus> buses,
        List <Stop> stops
) {
}
