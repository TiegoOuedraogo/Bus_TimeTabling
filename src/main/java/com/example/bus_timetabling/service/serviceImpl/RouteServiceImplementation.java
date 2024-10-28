package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.exception.RouteNotFoundException;
import com.example.bus_timetabling.repository.RouteRepository;
import com.example.bus_timetabling.service.RouteService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class RouteServiceImplementation implements RouteService {

    //constructor injection of Route Repository
    private final RouteRepository routeRepository;

    public RouteServiceImplementation(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public void createRoute(RouteRequestDto routeRequestDto) {

        //Create new Route
        Route route = new Route();
        route.setRouteName(routeRequestDto.getRouteName());
        route.setDistance(null);
        route.setRouteStopSchedule(null);
        route.setBusRouteManager(null);

        //Save route in database
        routeRepository.save(route);
    }

    @Override
    public List<RouteResponseDto> getAllRoutes() {
        //convert list of entities to response dto
   return routeRepository.findAll().
                stream().map(route -> new RouteResponseDto(
                        route.getId(),
                        route.getRouteName(),
                        route.getDistance()
                )).collect(Collectors.toList());
    }

    @Override
    public RouteResponseDto findRouteById(Long route_id) throws RouteNotFoundException {
        return routeRepository.findById(route_id).map(route -> new RouteResponseDto(
                        route.getId(),
                        route.getRouteName(),
                        route.getDistance()
                ))
                .orElse(null);
    }
    @Override
    public void deleteRouteById(Long route_id) {
        routeRepository.deleteById(route_id);

    }
}
