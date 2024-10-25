package com.example.bus_timetabling.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BusRouteManagerResponseDto {
    private Long id;
    private List<BusDto> bus_id;
    private List<RouteDto> route_id;
}
