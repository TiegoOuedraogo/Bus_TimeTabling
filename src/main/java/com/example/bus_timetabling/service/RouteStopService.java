package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteStopResponseDto;
import com.example.bus_timetabling.entities.RouteStop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteStopService {

    List<RouteStopResponseDto> getAllRouteStopSchedules();

    RouteStop findRouteStopScheduleById(Long id);

    RouteStopResponseDto getRouteStopScheduleById(Long id);
}