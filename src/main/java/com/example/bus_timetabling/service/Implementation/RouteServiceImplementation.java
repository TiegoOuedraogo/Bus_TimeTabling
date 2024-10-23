package com.example.bus_timetabling.service.Implementation;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.exception.RouteNotFoundException;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.RouteRepository;
import com.example.bus_timetabling.repository.StopRepository;
import com.example.bus_timetabling.service.RouteService;
import org.springframework.stereotype.Service;
import com.example.bus_timetabling.mapper.RouteMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImplementation implements RouteService {
    RouteRepository routeRepository;
    StopRepository stopRepository;
    BusRepository busRepository;

    public RouteServiceImplementation(RouteRepository routeRepository, StopRepository stopRepository, BusRepository busRepository) {
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
        this.busRepository = busRepository;
    }

    @Override
    public RouteDto createRoute(RouteDto routeDto) {
        return null;
    }

    @Override
    public List<RouteDto> retrieveAllRoutes() {

        return routeRepository.findAll().stream().map(routeMapper::toRouteDto).collect(Collectors.toList());

    }

    @Override
    public RouteDto findRouteById(Long route_id) throws RouteNotFoundException {
        return null;
    }

    @Override
    public RouteDto deleteRouteById(Long route_id) throws RouteNotFoundException {
        return null;
    }
}
