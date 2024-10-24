package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.RouteStopScheduleDto;
import com.example.bus_timetabling.dto.RouteStopScheduleResponseDto;
import com.example.bus_timetabling.entities.RouteStopSchedule;
import org.springframework.stereotype.Component;

@Component
public class RouteStopScheduleMapper {

    private final RouteMapper routeMapper;
    private final StopMapper stopMapper;

    public RouteStopScheduleMapper(RouteMapper routeMapper, StopMapper stopMapper) {
        this.routeMapper = routeMapper;
        this.stopMapper = stopMapper;
    }


    public RouteStopScheduleDto toRSDto(RouteStopSchedule rStop) {
        if(rStop == null) {
            return null;
        }

        RouteStopScheduleDto rs = new RouteStopScheduleDto();
        rs.setId(rStop.getId());
        rs.setStopNum(rStop.getStopNum());
        rs.setStop(stopMapper.toStopDto(rStop.getStop()));
        rs.setRoute(routeMapper.toDTO(rStop.getRoute()));

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
