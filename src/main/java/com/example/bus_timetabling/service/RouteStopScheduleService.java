package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteStopScheduleDto;
import com.example.bus_timetabling.dto.RouteStopScheduleResponseDto;
import com.example.bus_timetabling.entities.RouteStopSchedule;

import java.util.Arrays;
import java.util.List;

public interface RouteStopScheduleService {

    List<RouteStopScheduleResponseDto> getAllRouteStopSchedules();

    RouteStopSchedule findRouteStopScheduleById(Long id);

    RouteStopScheduleResponseDto getRouteStopScheduleById(Long id);
}
