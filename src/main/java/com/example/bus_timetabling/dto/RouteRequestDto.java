package com.example.bus_timetabling.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class RouteRequestDto {
    private String routeName;
    private String routeOrigin;
    private String destination;
    private Double distance;
    private List<StopRequestDto> stops;
    private List<BusRequestDto> buses;

}
