package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.exception.RouteNotFoundException;
import com.example.bus_timetabling.repository.BusRouteManagerRepository;
import com.example.bus_timetabling.repository.RouteRepository;
import com.example.bus_timetabling.repository.RouteStopScheduleRepository;
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
    private final RouteStopScheduleRepository routeStopScheduleRepository;
    private final BusRouteManagerRepository busRouteManagerRepository;

    public RouteServiceImplementation(RouteRepository routeRepository, RouteStopScheduleRepository routeStopScheduleRepository, BusRouteManagerRepository busRouteManagerRepository) {
        this.routeRepository = routeRepository;
        this.routeStopScheduleRepository = routeStopScheduleRepository;
        this.busRouteManagerRepository = busRouteManagerRepository;
    }

    @Override
    public void createRoute(RouteRequestDto routeRequestDto) {

        //Create new Route
        Route route = new Route();
        route.setId(routeRequestDto.getId());
        route.setRouteName(routeRequestDto.getRouteName());
        route.setDistance(routeRequestDto.getDistance());
        route.setRouteStopSchedule(routeStopScheduleRepository.findById(routeRequestDto.getRouteStopSchedule()).orElse(null));
        route.setBusRouteManager(busRouteManagerRepository.findById(routeRequestDto.getBusRouteManager()).orElse(null));

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
    public List<Route> findRouteById(Long route_id) throws RouteNotFoundException {
        return List.of();
    }

    @Override
    public void deleteRouteById(Long route_id) {
        routeRepository.deleteById(route_id);

    }
}
