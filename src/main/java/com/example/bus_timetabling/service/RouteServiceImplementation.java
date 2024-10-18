package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.exception.RouteNotFoundException;
import com.example.bus_timetabling.mapper.BusMapper;
import com.example.bus_timetabling.mapper.RouteMapper;
import com.example.bus_timetabling.mapper.StopMapper;
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


    public RouteServiceImplementation(RouteRepository routeRepository, BusRepository busRepository, StopRepository stopRepository, BusMapper busMapper, StopMapper stopMapper) {
        this.routeRepository = routeRepository;
        this.busRepository = busRepository;
        this.stopRepository = stopRepository;
        this.busMapper = busMapper;
        this.stopMapper = stopMapper;
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
                routeDto.getStops().stream().map(stopMapper::toStop).collect(Collectors.toList()),
        routeDto.getBuses().stream().map(busMapper:: toBus).collect(Collectors.toList())
        );

        //Save entity to repo
        Route savedRoute = routeRepository.save(route);
    }


    @Override
    public List<RouteDto> retrieveAllRoutes() {
        return routeRepository.findAll().stream().map(routeMapper::toRouteDto).collect(Collectors.toList());
    }


    @Override
    public RouteDto deleteRouteById(Long route_id) throws RouteNotFoundException {
        //Find route from route_id
        RouteDto routeDto = routeRepository.findById(route_id).map(routeMapper::toRouteDto).orElse(null);

        //Convert routeDTO to route entity
        Route route = routeMapper.toRoute(routeDto);
        //Delete DTO from repo
        routeRepository.delete(route);

        return routeDto;
    }

 @Override
    public RouteDto findRouteById(Long route_id) throws RouteNotFoundException {
        return routeRepository.findById(route_id).map(routeMapper::toRouteDto).orElse(null);
    }


}
