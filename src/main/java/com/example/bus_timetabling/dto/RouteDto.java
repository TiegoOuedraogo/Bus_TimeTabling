package com.example.bus_timetabling.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class RouteDto {
    private Long id;
    private String routeName;
    private Long toStopId;
    private Long fromStopId;
    private Double distance;

}