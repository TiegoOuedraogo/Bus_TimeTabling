package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.dto.RouteRequestDto;
import com.example.bus_timetabling.dto.RouteResponseDto;
import com.example.bus_timetabling.exception.RouteNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
//
import java.util.List;

@Service
public interface RouteService {
  void createRoute(RouteRequestDto routeRequestDto);
  List<RouteResponseDto> getAllRoutes();
  RouteResponseDto findRouteById(Long route_id) throws RouteNotFoundException;
  void deleteRouteById(Long route_id);
}
