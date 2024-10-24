package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.StopRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteMapper {

    private final RouteStopScheduleMapper RSMapper;
    private final BusRouteManagerMapper BRMMapper;

    public RouteMapper(RouteStopScheduleMapper rsMapper, BusRouteManagerMapper brmMapper){

        RSMapper = rsMapper;
        BRMMapper = brmMapper;
    }

    // DTO to Entity
    public Route toRoute(RouteResponseDto routeResponseDto){
       //Create and return Route Entity
        return new Route(
                routeResponseDto.getId(),
                routeResponseDto.getRouteName(),
                routeResponseDto.getDistance(),
                RSMapper.toRS(routeResponseDto.getRouteStopSchedule()), //convert lists dto to list entity using stop mapper
                BRMMapper.toBRM(routeResponseDto.getBusRouteManager()) //convert lists dto to list entity using bus mapper
        );
    }

    public Route fromDtotoRoute(RouteDto dto) {
        if(dto == null) {
            return null;
        }

        Route route = new Route();
        route.setId(dto.getId());
        route.setRouteName(dto.getRouteName());
        route.setDistance(dto.getDistance());
        route.setBusRouteManager(BRMMapper.toBRM(dto.getBusRouteManager()));
        route.setRouteStopSchedules(RSMapper.toRS(dto.getRouteStopSchedule()));
        return route;
    }

    // Entity to DTO
    public RouteDto toDTO(Route route){
        return new RouteDto(
                route.getId(),
                route.getRouteName(),
                route.getDistance(),
                RSMapper.toRSDto(route.getRouteStopSchedules()), //convert lists entity to list dto using stop mapper
                BRMMapper.toDto(route.getBusRouteManager()) //convert lists entity to list dto using bus mapper
        );
    }

}
