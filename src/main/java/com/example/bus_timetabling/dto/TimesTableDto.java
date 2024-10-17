package com.example.bus_timetabling.dto;

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
    private LocalTime departure;
    private LocalTime arrival;
    private Double segmentDistance;
    private Long busId;
    private Long fromStopId;
    private Long toStopId;
}