package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.entities.Stop;
import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TimesTableDto {
    private Long id;
    private Stop fromStop;
    private Stop toStop;
    private LocalTime departure;
    private LocalTime arrival;
    private Bus bus;
}