package com.example.bus_timetabling.dto;

import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class RouteWithStopsDto {
    private Long routeId;
    private String routeName;
    private List<StopResponseDto> stops;
}
