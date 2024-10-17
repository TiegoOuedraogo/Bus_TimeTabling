package com.example.bus_timetabling.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class StopRequestDto {
    private String stopName;
    private Long routeId;
}