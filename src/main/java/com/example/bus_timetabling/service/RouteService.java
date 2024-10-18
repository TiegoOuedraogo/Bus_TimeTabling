package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.exception.RouteNotFoundException;

import java.util.List;

public interface RouteService<Route ,Long> {
 void createRoute(RouteDto routeDto);
  List<RouteDto> retrieveAllRoutes ();
 RouteDto deleteRouteById(java.lang.Long route_id) throws RouteNotFoundException;
 RouteDto findRouteById(java.lang.Long route_id) throws RouteNotFoundException;
}
