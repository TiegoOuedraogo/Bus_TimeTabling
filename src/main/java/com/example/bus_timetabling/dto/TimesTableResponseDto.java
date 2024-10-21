package com.example.bus_timetabling.dto;

import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TimesTableResponseDto {
    private Long fromStopId;
    private Long toStopId;
    private LocalTime departure;
    private LocalTime arrival;
    private Long busId;
    private Long routeId;
}