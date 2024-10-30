package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.entities.Stop;
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
    private List<Stop> stops;
    private Route route;
}
