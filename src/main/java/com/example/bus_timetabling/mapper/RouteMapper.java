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
        route.setToStopId(dto.getToStopId());
        route.setFromStopId(dto.getFromStopId());
        route.setDistance(dto.getDistance());
        return route;
    }

    public RouteDto toRouteDto(Route entity) {
        if (entity == null) {
            return null;
        }

        RouteDto dto = new RouteDto();
        dto.setId(entity.getId());
        dto.setRouteName(entity.getRouteName());
        dto.setToStopId(entity.getToStopId());
        dto.setFromStopId(entity.getFromStopId());
        dto.setDistance(entity.getDistance());
        return dto;
    }
}

