package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.RouteStopScheduleDto;
import com.example.bus_timetabling.dto.RouteStopScheduleResponseDto;
import com.example.bus_timetabling.entities.RouteStopSchedule;
import com.example.bus_timetabling.exception.RouteStopScheduleNotFoundException;
import com.example.bus_timetabling.service.RouteStopScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteStopScheduleServiceImpl implements RouteStopScheduleService {

    private RouteStopScheduleService routeStopScheduleService;

//    @Override
//    public void createRouteStopSchedule(RouteStopScheduleResponseDto routeStopScheduleResponseDto) {
//
//    }
//
//    @Override
//    public List<RouteStopScheduleDto> retrieveAllRouteStopSchedules() {
//        return List.of();
//    }
//
//    @Override
//    public RouteStopScheduleDto findRouteScheduleById(Long route_stop_id) throws RouteStopScheduleNotFoundException {
//        return null;
//    }
//
//    @Override
//    public void deleteRouteStopScheduleById(Long route_stop_id) throws RouteStopScheduleNotFoundException {
//
//    }

    @Override
    public List<RouteStopScheduleResponseDto> getAllRouteStopSchedules() {
        return routeStopScheduleService.getAllRouteStopSchedules();
    }

    @Override
    public RouteStopSchedule findRouteStopScheduleById(Long id) {
        return routeStopScheduleService.findRouteStopScheduleById(id);
    }

//    @Override
//    public RouteStopScheduleResponseDto getRouteStopScheduleById(Long id) {
//        return mapRouteStopScheduleResponse(routeStopScheduleService.findRouteStopScheduleById(id));
//    }


    private RouteStopScheduleResponseDto mapRouteStopScheduleResponse(RouteStopSchedule routeStopSche){
        return RouteStopScheduleResponseDto.builder()
               .id(routeStopSche.getId())
               .stopNum(routeStopSche.getStopNum())
               .build();
    }

}

