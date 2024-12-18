package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.RouteStopSchedule;
import com.example.bus_timetabling.entities.TimesTable;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class StopResponseDto {
    private Long id;
    private String stopName;
}