package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.BusRouteManager;
import com.example.bus_timetabling.entities.RouteStopSchedule;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.enums.Service;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class BusDto {
    private Long id;
    private String busNumber;
    private Service status;
    private Stop toStopId;
    private Stop fromStopId;
    private BusRouteManager bus_Route;
}