package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.exception.RouteNotFoundException;
import org.springframework.stereotype.Service;
//
import java.util.List;

@Service
public interface RouteService {
  void createRoute(RouteRequestDto routeRequestDto);
  List<RouteResponseDto> getAllRoutes();
  List<Route> findRouteById(Long route_id) throws RouteNotFoundException;
  void deleteRouteById(Long route_id);
}
