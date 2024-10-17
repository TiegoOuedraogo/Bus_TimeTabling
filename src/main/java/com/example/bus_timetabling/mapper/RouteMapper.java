package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.entities.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {

    public Route toRoute(RouteDto dto) {
        if (dto == null) {
            return null;
        }

        Route route = new Route();

        route.setId(dto.getId());
        route.setRouteName(dto.getRouteName());
        route.setRouteOrigin(dto.getOrigin());
        route.setDestination(dto.getDestination());
        return route;
    }

    public RouteDto toRouteDto(Route entity) {
        if (entity == null) {
            return null;
        }

        RouteDto dto = new RouteDto();
        dto.setId(entity.getId());
        dto.setRouteName(entity.getRouteName());
        dto.setOrigin(entity.getRouteOrigin());
        dto.setDestination(entity.getDestination());
        return dto;
    }
}

