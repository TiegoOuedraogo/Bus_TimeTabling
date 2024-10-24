package com.example.bus_timetabling.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class RouteStopScheduleResponseDto {
    private Long id;
    private int stopNum;
    private List<StopResponseDto> stops;
    private List<RouteResponseDto> routes;
}
