package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.BusRouteManager;
import com.example.bus_timetabling.entities.RouteStopSchedule;
import com.example.bus_timetabling.entities.Stop;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class RouteResponseDto {
    private Long id;
    private String routeName;
    private Double distance;
    private RouteStopScheduleDto routeStopSchedule;
    private BusRouteManagerDto busRouteManager;
}