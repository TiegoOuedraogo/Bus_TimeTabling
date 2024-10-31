package com.example.bus_timetabling.dto;

import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

public class TimetableResponseDto {

    private Long id;
    private Long busId;
    private Long stopId;
    private LocalTime arrival;
    private LocalTime departure;

}


