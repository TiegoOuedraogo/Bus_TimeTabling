package com.example.bus_timetabling.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BusRouteManagerDto {
    private Long id;
    private Long bus_id;
    private Long route_id;

}
