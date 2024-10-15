package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.exception.RouteNotFoundException;
import com.example.bus_timetabling.mapper.RouteMapper;
import com.example.bus_timetabling.repository.RouteRepository;

import java.util.List;

public class RouteServiceImplementation implements RouteService {
    private final RouteRepository routeRepository;

    public RouteServiceImplementation(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public RouteResponseDto createRoute(RouteRequestDto routeRequestDto) {
return null;
      /*  //Create Route
        Route route =

                //Save new Route to Data Base
        Route savedRoute = routeRepository.save(//route entity)

                //return DTO
                return RouteMapper.toDTO(savedRoute)
*/
    }

    @Override
    public List<RouteResponseDto> retrieveAllRoutes() {
//        return routeRepository.findAll();
        return List.of();
    }

    @Override
    public RouteResponseDto findRouteById(Object route_id) throws RouteNotFoundException {
        return null;
    }

    @Override
    public RouteResponseDto deleteRouteById(Object route_id) throws RouteNotFoundException {
        return null;
    }
}
