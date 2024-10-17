package com.example.bus_timetabling.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class StopDto {
    private Long id;
    private String stopName;
    private Integer orderInRoute;
    private String routeName;
    private Long routeId;
}