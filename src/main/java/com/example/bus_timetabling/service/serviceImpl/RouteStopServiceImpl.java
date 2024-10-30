package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.RouteStopResponseDto;
import com.example.bus_timetabling.entities.RouteStop;
import com.example.bus_timetabling.repository.RouteRepository;
import com.example.bus_timetabling.repository.RouteStopRepository;
import com.example.bus_timetabling.repository.StopRepository;
import com.example.bus_timetabling.service.RouteStopService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteStopServiceImpl implements RouteStopService {
    private final RouteStopRepository routeStopRepository;
    private final RouteRepository routeRepository;
    private final StopRepository stopRepository;

    public RouteStopServiceImpl(RouteStopRepository routeStopRepository,
                                RouteRepository routeRepository, StopRepository stopRepository) {
        this.routeStopRepository = routeStopRepository;
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
    }

    @Override
    public List<RouteStopResponseDto> getAllRouteStopSchedules() {
        return routeStopRepository.findAll()
                .stream()
                .map(this::mapRouteStopScheduleResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public RouteStop findRouteStopScheduleById(Long id) {
        return null;
    }

    @Override
    public RouteStopResponseDto getRouteStopScheduleById(Long id) {
        return routeStopRepository.findById(id)
                .map(this::mapRouteStopScheduleResponseDto)
                .orElseThrow();
    }



//    private RouteStopResponseDto mapRouteStopScheduleResponseDto(RouteStop routeStopSchedule) {
//        return RouteStopResponseDto.builder()
//                .id(routeStopSchedule.getId())
//                .stopNum(routeStopSchedule.getStopNum())
//                .stops(routeStopSchedule.getStops())
//                .route(routeStopSchedule.getRoutes().isEmpty() ? null : routeStopSchedule.getRoutes().get(0)) // Check if routes list is empty
//                .build();
//    }

    private RouteStopResponseDto mapRouteStopScheduleResponseDto(RouteStop routeStop) {
        return RouteStopResponseDto.builder()
                .id(routeStop.getId())
                .stopNum(routeStop.getStopNum())
//                .stops(routeStop.getStops())
                .route(routeStop.getRoute())
                .build();
    }



}
