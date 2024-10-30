package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.BusRouteManager;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.entities.TimesTable;
import com.example.bus_timetabling.enums.ServiceStatus;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusDto {
    private Long id;
    private String busNumber;
    private ServiceStatus status;
    private Stop toStop;
    private Stop fromStop;
    private BusRouteManager bus_Route;
    private List<Stop> stops;



}