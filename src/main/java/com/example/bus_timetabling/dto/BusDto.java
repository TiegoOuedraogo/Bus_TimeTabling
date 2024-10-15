package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Route;

import java.util.List;


public  record BusDto( 
     Long id,
     String busNumber,
     Integer capacity,
     String status,
     RouteDto route,
     List<TimesTableDto> timesTables,
     List<Route> routes
){}
