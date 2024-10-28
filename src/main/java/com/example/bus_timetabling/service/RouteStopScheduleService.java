package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteStopScheduleDto;
import com.example.bus_timetabling.dto.RouteStopScheduleResponseDto;
import com.example.bus_timetabling.entities.RouteStopSchedule;
import com.example.bus_timetabling.exception.RouteStopScheduleNotFoundException;

import java.util.List;

public interface RouteStopScheduleService {
//    void createRouteStopSchedule(RouteStopScheduleResponseDto routeStopScheduleResponseDto);
//
//    List<RouteStopScheduleDto> retrieveAllRouteStopSchedules ();
//
//    RouteStopScheduleDto findRouteScheduleById(Long route_stop_id) throws RouteStopScheduleNotFoundException;
//
//    void deleteRouteStopScheduleById(Long route_stop_id) throws RouteStopScheduleNotFoundException;

    List<RouteStopScheduleResponseDto> getAllRouteStopSchedules();

    RouteStopSchedule findRouteStopScheduleById(Long id);

//    RouteStopScheduleResponseDto getRouteStopScheduleById(Long id);
}
