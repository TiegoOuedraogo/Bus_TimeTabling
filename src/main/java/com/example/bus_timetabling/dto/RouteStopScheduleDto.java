package com.example.bus_timetabling.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class RouteStopScheduleDto {
    private Long id;
    private int stopNum;
    private Long stopId;
    private Long routeId;
}
