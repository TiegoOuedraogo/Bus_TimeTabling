package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.dto.RouteStopScheduleResponseDto;
import com.example.bus_timetabling.entities.RouteStopSchedule;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RouteStopScheduleResponseDtoMapper {
    private final RouteMapper routeMapper;
    private final StopMapper stopMapper;


    public RouteStopScheduleResponseDtoMapper(RouteMapper routeMapper, StopMapper stopMapper) {
        this.routeMapper = routeMapper;
        this.stopMapper = stopMapper;
    }

    //Dto to Entity
    public RouteStopSchedule toEntity(RouteStopScheduleResponseDto RouteStopScheduleResponseDto) {
       return new RouteStopSchedule(
               RouteStopScheduleResponseDto.getId(),
               RouteStopScheduleResponseDto.getStopNum(),
               //convert list of stops dto to list of stops entity
               RouteStopScheduleResponseDto.getStops().stream().map(stopMapper::toEntity).collect(Collectors.toList()),
               //convert list of routes dto to list of routes entity
               RouteStopScheduleResponseDto.getRoutes().stream().map(routeMapper::toEntity).collect(Collectors.toList())
       );
    }

    //Entity to ResponseDTO
    public RouteResponseDto toDTO(RouteStopSchedule routeStopSchedule){
        return new RouteResponseDto(
                routeStopSchedule.getId(),
                routeStopSchedule.getStopNum(),
                //Convert list of stops entity  to list of stop response dto
                routeStopSchedule.getStops().stream().map(stopMapper::toDTO).collect(Collectors.toList()),
                //Convert list of routes entity to list of route response dto
                routeStopSchedule.getRoutes().stream().map(routeMapper::toDTO).collect(Collectors.toList())
        );

    }
}
