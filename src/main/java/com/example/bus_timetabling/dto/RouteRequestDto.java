package com.example.bus_timetabling.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class RouteRequestDto {
    private Long id;
    private String routeName;
    private Double distance;
    private Long routeStopSchedule;
    private Long busRouteManager;
}