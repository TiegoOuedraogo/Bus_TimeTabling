package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.exception.RouteNotFoundException;

import java.util.List;

public interface RouteService<Route ,Long> {
 void createRoute(RouteRequestDto routeRequestDto);
  List<RouteDto> retrieveAllRoutes ();
//  RouteDto findRouteById(Long route_id) throws RouteNotFoundException;

  RouteDto deleteRouteById (Long route_id) throws RouteNotFoundException;
}
