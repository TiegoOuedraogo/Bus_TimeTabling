package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.RouteStopRequestDto;
import com.example.bus_timetabling.dto.RouteStopResponseDto;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.entities.RouteStop;
import com.example.bus_timetabling.entities.RouteStopId;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.exception.ResourceNotFoundException;
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
    public List<RouteStopResponseDto> getAllRouteStops() {
        return routeStopRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public RouteStopResponseDto createRouteStop(RouteStopRequestDto requestDto) throws ResourceNotFoundException {
        Route route = routeRepository.findById(requestDto.getRouteId())
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id " + requestDto.getRouteId()));

        Stop stop = stopRepository.findById(requestDto.getStopId())
                .orElseThrow(() -> new ResourceNotFoundException("Stop not found with id " + requestDto.getStopId()));

        RouteStopId id = new RouteStopId(requestDto.getRouteId(), requestDto.getStopId());

        if (routeStopRepository.existsById(id)) {
            throw new IllegalArgumentException("RouteStop already exists for the given Route and Stop IDs");
        }

        RouteStop routeStop = new RouteStop();
        routeStop.setId(id);
        routeStop.setRoute(route);
        routeStop.setStop(stop);
        routeStop.setStopNum(requestDto.getStopNum());

        RouteStop savedRouteStop = routeStopRepository.save(routeStop);

        return toResponseDto(savedRouteStop);
    }

    @Override
    public void deleteRouteStop(Long routeId, Long stopId) throws ResourceNotFoundException {
        RouteStopId id = new RouteStopId(routeId, stopId);
        if (!routeStopRepository.existsById(id)) {
            throw new ResourceNotFoundException("RouteStop not found with Route ID " + routeId + " and Stop ID " + stopId);
        }
        routeStopRepository.deleteById(id);
    }

    private RouteStopResponseDto toResponseDto(RouteStop routeStop) {
        return new RouteStopResponseDto(
                routeStop.getRoute().getId(),
                routeStop.getStop().getId(),
                routeStop.getStopNum()
        );
    }
}
