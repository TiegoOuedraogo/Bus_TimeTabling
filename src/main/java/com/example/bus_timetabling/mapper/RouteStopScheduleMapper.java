package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.RouteStopScheduleDto;
import com.example.bus_timetabling.dto.RouteStopScheduleResponseDto;
import com.example.bus_timetabling.entities.RouteStopSchedule;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RouteStopScheduleMapper {

public class RouteStopScheduleResponseDtoMapper {
    private final RouteMapper routeMapper;
    private final StopMapper stopMapper;

    public RouteStopScheduleMapper(RouteMapper routeMapper, StopMapper stopMapper) {

    public RouteStopScheduleResponseDtoMapper(RouteMapper routeMapper, StopMapper stopMapper) {
        this.routeMapper = routeMapper;
        this.stopMapper = stopMapper;
    }


    public RouteStopScheduleDto toRSDto(RouteStopSchedule rStop) {
        if(rStop == null) {
            return null;
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

        RouteStopScheduleDto rs = new RouteStopScheduleDto();
        rs.setId(rStop.getId());
        rs.setStopNum(rStop.getStopNum());
        rs.setStop(stopMapper.toStopDto(rStop.getStop()));
        rs.setRoute(routeMapper.toDTO(rStop.getRoute()));
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

        return rs;
    }

    public RouteStopSchedule fromResponsetoRS(RouteStopScheduleResponseDto dto) {
        if(dto == null) {
            return null;
        }

        RouteStopSchedule rs = new RouteStopSchedule();
        rs.setId(dto.getId());
        rs.setRoute(routeMapper.fromDtotoRoute(dto.getRoute()));
        return rs;
    }

    public RouteStopSchedule toRS(RouteStopScheduleDto dto) {
        if(dto == null) {
            return null;
        }

        RouteStopSchedule rs = new RouteStopSchedule();
        rs.setId(dto.getId());
        rs.setStop(stopMapper.toStop(dto.getStop()));
        rs.setStopNum(dto.getStopNum());
        rs.setRoute(routeMapper.fromDtotoRoute(dto.getRoute()));
        return rs;
    }
}
