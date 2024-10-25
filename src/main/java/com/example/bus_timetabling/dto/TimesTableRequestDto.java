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
public class TimesTableRequestDto {
    private StopDto fromStop;
    private StopDto toStop;
    private LocalTime departure;
    private LocalTime arrival;
    private BusDto bus;
    private RouteDto route;
}