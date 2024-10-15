package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.enums.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.List;


@Getter
@Setter

public record BusResponseDto
    ( Long id,
     String busNumber,
     Integer capacity,
     Service status,
     RouteDto route,
     List<TimesTableDto> timesTables,
     List<Route> routes){


}

