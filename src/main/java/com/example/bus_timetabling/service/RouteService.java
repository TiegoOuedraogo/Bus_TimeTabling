package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.exception.RouteNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteService<Route ,Long> {
  RouteResponseDto createRoute(RouteRequestDto routeRequestDto);
  List<RouteResponseDto> retrieveAllRoutes ();
  RouteResponseDto findRouteById(Long route_id) throws RouteNotFoundException;
  RouteResponseDto deleteRouteById (Long route_id) throws RouteNotFoundException;
}
