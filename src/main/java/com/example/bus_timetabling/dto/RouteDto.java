package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Stop;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public record RouteDto(
        Long route_id,
        String route_name,
        String origin,
        String destination,
        Double distance,
        List <Stop> stops,
        List<Bus> buses

public class RouteDto {
    private Long id;
    private String routeName;
    private String routeOrigin;
    private String destination;
    private Double distance;
    private List<Stop> stops = new ArrayList<>();
    private List<Bus> buses = new ArrayList<>();

}
