package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.StopRepository;

import java.util.List;

public class RouteMapper {
    private final BusRepository busRepository;
    private final StopRepository stopRepository;

    public RouteMapper(BusRepository busRepository , StopRepository stopRepository){
        this.busRepository = busRepository;
        this.stopRepository = stopRepository;
    }

    // DTO to Entity
    public Route toEntity(RouteResponseDto routeResponseDto){

        //Fetch List of buses and stops
        List<Bus> buses = busRepository.retrieveAllBuses();
        List <Stop> stops = stopRepository.retrieveAllStops();

       //Create and return Route Entity
        return new Route(
                routeResponseDto.route_id(),
                routeResponseDto.route_name(),
                routeResponseDto.origin(),
                routeResponseDto.destination(),
                routeResponseDto.distance(),
                stops,
                buses
        );
    }

    // Entity to DTO
    public static RouteResponseDto toDTO(Route route){
        return new RouteResponseDto(
                route.getId(),
                route.getRouteName(),
                route.getRouteOrigin(),
                route.getDestination(),
                route.getDistance()
        );
    }
}
