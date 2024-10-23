package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.exception.RouteNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RouteService {
  RouteDto createRoute(RouteDto routeDto);

  List<RouteDto> retrieveAllRoutes ();
    @Query("SELECT b FROM Bus b WHERE b.busRouteManager.id = :routeId")
  RouteDto findRouteById(java.lang.Long route_id) throws RouteNotFoundException;

  RouteDto deleteRouteById(java.lang.Long route_id) throws RouteNotFoundException;
}
