package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Route;
import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TimesTableDto {
    private Long fromStopId;
    private Long toStopId;
    private LocalTime departure;
    private LocalTime arrival;
    private Bus bus;
    private Route route;
}