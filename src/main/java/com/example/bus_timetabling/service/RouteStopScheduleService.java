package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteStopScheduleDto;
import com.example.bus_timetabling.exception.RouteStopScheduleNotFoundException;

import java.util.List;

public interface RouteStopScheduleService {
    void createRouteStopSchedule(RouteStopScheduleDto routeStopScheduleDto);

    List<RouteStopScheduleDto> retrieveAllRouteStopSchedules ();

    RouteStopScheduleDto findRouteScheduleById(Long route_stop_id) throws RouteStopScheduleNotFoundException;

    void deleteRouteById(Long route_stop_id) throws RouteStopScheduleNotFoundException;
}
