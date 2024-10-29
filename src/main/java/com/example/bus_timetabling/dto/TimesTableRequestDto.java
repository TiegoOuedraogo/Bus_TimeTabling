package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Route;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TimesTableRequestDto {
    private Long timeTble_id;
    private LocalTime arrival = LocalTime.now();
    private Long stopId;
}