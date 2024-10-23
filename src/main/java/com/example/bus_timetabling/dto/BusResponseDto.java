package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.BusRouteManager;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.enums.ServiceStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BusResponseDto {
    private Long id;
    private String busNumber;
    private ServiceStatus status;
    private Stop toStopId;
    private Stop fromStopId;
    private BusRouteManager bus_Route;

}