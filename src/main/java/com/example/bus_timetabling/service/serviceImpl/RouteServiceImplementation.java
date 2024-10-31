package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.exception.ResourceNotFoundException;
import com.example.bus_timetabling.repository.RouteRepository;
import com.example.bus_timetabling.service.RouteService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class RouteServiceImplementation implements RouteService {

    private final RouteRepository routeRepository;

    public RouteServiceImplementation(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public RouteResponseDto createRoute(RouteRequestDto routeRequestDto) {
        Route route = new Route();
        route.setRouteName(routeRequestDto.getRouteName());
        route.setDistance(routeRequestDto.getDistance());
        Route savedRoute = routeRepository.save(route);

        return toResponseDto(savedRoute);
    }

    @Override
    public List<RouteResponseDto> getAllRoutes() {
        // Convert list of entities to response DTOs
        return routeRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public RouteResponseDto findRouteById(Long routeId) throws ResourceNotFoundException {
        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id " + routeId));
        return toResponseDto(route);
    }

    @Override
    public RouteResponseDto updateRoute(Long routeId, RouteRequestDto routeRequestDto) throws ResourceNotFoundException {
        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id " + routeId));

        route.setRouteName(routeRequestDto.getRouteName());
        route.setDistance(routeRequestDto.getDistance());

        Route updatedRoute = routeRepository.save(route);

        return toResponseDto(updatedRoute);
    }

    @Override
    public void deleteRoute(Long routeId) throws ResourceNotFoundException {
        if (!routeRepository.existsById(routeId)) {
            throw new ResourceNotFoundException("Route not found with id " + routeId);
        }
        routeRepository.deleteById(routeId);
    }


    // Mapping method
    private RouteResponseDto toResponseDto(Route route) {
        return new RouteResponseDto(
                route.getId(),
                route.getRouteName(),
                route.getDistance()
        );
    }
}
