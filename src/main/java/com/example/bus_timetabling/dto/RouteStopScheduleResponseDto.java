package com.example.bus_timetabling.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class RouteStopScheduleResponseDto {
    private Long id;
    private int stopNum;
    private StopDto stop;
    private RouteDto route;
}
