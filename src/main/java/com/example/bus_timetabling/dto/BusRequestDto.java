package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.RouteStopSchedule;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.enums.Service;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BusRequestDto {
    private String busNumber;
}