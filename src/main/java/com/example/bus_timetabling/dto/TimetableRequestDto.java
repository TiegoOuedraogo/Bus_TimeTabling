package com.example.bus_timetabling.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TimetableRequestDto {
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

