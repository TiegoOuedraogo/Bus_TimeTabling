package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteStopScheduleDto;
import com.example.bus_timetabling.dto.RouteStopScheduleResponseDto;
import com.example.bus_timetabling.entities.RouteStopSchedule;
import com.example.bus_timetabling.exception.RouteStopScheduleNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteStopScheduleService {

    List<RouteStopScheduleResponseDto> getAllRouteStopSchedules();

    RouteStopSchedule findRouteStopScheduleById(Long id);

}