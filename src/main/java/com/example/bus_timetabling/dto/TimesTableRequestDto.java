package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Route;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Long busId;

    @NotNull
    private Long routeId;

    @NotNull
    private Long stopId;

    @NotNull
    private LocalTime arrival;

    @NotNull
    private LocalTime departure;
}

