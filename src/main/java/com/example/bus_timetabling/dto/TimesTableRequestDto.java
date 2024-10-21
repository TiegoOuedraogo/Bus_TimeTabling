package com.example.bus_timetabling.dto;

import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TimesTableRequestDto {
    private LocalTime departure;
    private LocalTime arrival;
    private Long busId;
    private Long fromStopId;
    private Long toStopId;
}