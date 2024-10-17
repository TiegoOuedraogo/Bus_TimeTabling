package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.exception.RouteNotFoundException;
import com.example.bus_timetabling.mapper.BusMapper;
import com.example.bus_timetabling.mapper.RouteMapper;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.RouteRepository;
import com.example.bus_timetabling.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImplementation implements RouteService {
    private final RouteRepository routeRepository;
    private final BusRepository busRepository;
    private final StopRepository stopRepository;
    private RouteMapper routeMapper;
    private BusMapper busMapper;
    private StopMapper stopMapper;


    public RouteServiceImplementation(RouteRepository routeRepository, BusRepository busRepository, StopRepository stopRepository, BusMapper busMapper) {
        this.routeRepository = routeRepository;
        this.busRepository = busRepository;
        this.stopRepository = stopRepository;
        this.busMapper = busMapper;
    }

    @Override
    public void createRoute(RouteDto routeDto) {
        //Find Route from Route Request Dto
        Route route = new Route (
                routeDto.getId(),
                routeDto.getRouteName(),
                routeDto.getOrigin(),
                routeDto.getDestination(),
                routeDto.getDistance(),
                routeDto.getStops().stream().map(StopMapper:: toStop).collect(Collectors.toList()),
        routeDto.getBuses().stream().map(BusMapper:: toBus).collect(Collectors.toList())
        );

        //Save entity to repo
        Route savedRoute = routeRepository.save(route);
    }

    @Override
    public List<RouteDto> retrieveAllRoutes() {
        return routeRepository.findAll().stream().map(routeMapper::toRouteDto).collect(Collectors.toList());
    }


    public RouteDto findRouteById(Long route_id) throws RouteNotFoundException {
        return routeRepository.findById(route_id).map(routeMapper::toRouteDto).orElse(null);
    }

    @Override
    public RouteDto deleteRouteById(Long route_id) throws RouteNotFoundException {
        //Find route from route_id
        RouteDto routeDto = routeRepository.findById(route_id).map(routeMapper::toRouteDto).orElse(null);

        //Delete DTO from repo
        routeRepository.delete(routeRepository.findBy(route_id));

        return routeDto;
    }
}
