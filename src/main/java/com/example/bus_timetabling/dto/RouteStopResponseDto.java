package com.example.bus_timetabling.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class RouteStopResponseDto {
    private Long routeId;
    private Long stopId;
    private Integer stopNum;
}

