package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.dto.StopDto;
import com.example.bus_timetabling.entities.Route;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RouteMapper {
    private final BusMapper busMapper;
    private final StopMapper stopMapper;

    public RouteMapper(BusMapper busMapper, StopMapper stopMapper) {
        this.busMapper = busMapper;
        this.stopMapper = stopMapper;
    }

    public Route toRoute(RouteDto dto) {
        if (dto == null) {
            return null;
        }
        Route route = new Route();
        route.setId(dto.getId());
        route.setRouteName(dto.getRouteName());
        route.setRouteOrigin(dto.getRouteOrigin());
        route.setDestination(dto.getDestination());
        route.setDistance(dto.getDistance());
        route.setStops(dto.getStops()); //convert from list of DTOs to route
        route.setBuses(dto.getBuses()); //convert from list of DTOs to route
        return route;
    }

    public RouteDto toRouteResponseDto(Route route) {
        if (route == null) {
            return null;
        }
        RouteDto dto = new RouteDto();
        dto.setId(route.getId());
        dto.setRouteName(route.getRouteName());
        dto.setRouteOrigin(route.getRouteOrigin());
        dto.setDestination(route.getDestination());
       
       //Convert list of Stops from route to DTOs
        List<StopDto> stopDtos = route.getStops() !=null
                ? route.getStops().stream()
                .map(stopMapper::toStopResponseDto)
                .collect(Collectors.toList())
                : null;
        dto.setStops(stopDtos); //convert route to dtos
       
        //Convert list of Buses route to dtos
        List<BusResponseDto> busResponseDtos = route.getBuses() !=null
                ? route.getBuses().stream()
                .map(busMapper::toBusResponseDto)
                .collect(Collectors.toList())
                : null;
        dto.setBuses(busResponseDtos); //convert route to dtos
        return dto;
    }
}
