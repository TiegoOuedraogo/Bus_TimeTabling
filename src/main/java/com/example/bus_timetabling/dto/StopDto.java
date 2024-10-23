package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.entities.TimesTable;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class StopDto {
    private Long id;
    private String stopName;
    private List<TimesTable> departureTimesTable;
    private List<TimesTable> arrivalTimesTable;
}