package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.RouteStopScheduleResponseDto;
import com.example.bus_timetabling.entities.RouteStopSchedule;
import com.example.bus_timetabling.exception.ResourceNotFoundException;
import com.example.bus_timetabling.repository.RouteRepository;
import com.example.bus_timetabling.repository.RouteStopScheduleRepository;
import com.example.bus_timetabling.repository.StopRepository;
import com.example.bus_timetabling.service.RouteStopScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteStopScheduleServiceImpl implements RouteStopScheduleService {
    private final RouteStopScheduleRepository routeStopScheduleRepository;
    private final RouteRepository routeRepository;
    private final StopRepository stopRepository;

    public RouteStopScheduleServiceImpl(RouteStopScheduleRepository routeStopScheduleRepository,
                                        RouteRepository routeRepository, StopRepository stopRepository) {
        this.routeStopScheduleRepository = routeStopScheduleRepository;
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
    }

    @Override
    public List<RouteStopScheduleResponseDto> getAllRouteStopSchedules() {
        return routeStopScheduleRepository.findAll()
                .stream()
                .map(this::mapRouteStopScheduleResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public RouteStopSchedule findRouteStopScheduleById(Long id) {
        return null;
    }

    @Override
    public RouteStopScheduleResponseDto getRouteStopScheduleById(Long id) {
        return routeStopScheduleRepository.findById(id)
                .map(this::mapRouteStopScheduleResponseDto)
                .orElseThrow();
    }



//    private RouteStopScheduleResponseDto mapRouteStopScheduleResponseDto(RouteStopSchedule routeStopSchedule) {
//        return RouteStopScheduleResponseDto.builder()
//                .id(routeStopSchedule.getId())
//                .stopNum(routeStopSchedule.getStopNum())
//                .stops(routeStopSchedule.getStops())
//                .route(routeStopSchedule.getRoutes().isEmpty() ? null : routeStopSchedule.getRoutes().get(0)) // Check if routes list is empty
//                .build();
//    }

    private RouteStopScheduleResponseDto mapRouteStopScheduleResponseDto(RouteStopSchedule routeStopSchedule) {
        return RouteStopScheduleResponseDto.builder()
                .id(routeStopSchedule.getId())
                .stopNum(routeStopSchedule.getStopNum())
//                .stops(routeStopSchedule.getStops())
                .route(routeStopSchedule.getRoute())
                .build();
    }



}
