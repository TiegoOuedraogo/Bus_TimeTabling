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
    private Long id;
    private LocalTime departure;
    private LocalTime arrival;
    private Double segmentDistance;
    private Long busId;
    private String busNumber;
    private Long fromStopId;
    private String fromStopName;
    private Long toStopId;
    private String toStopName;
}