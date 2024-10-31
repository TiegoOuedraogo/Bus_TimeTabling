package com.example.bus_timetabling.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BusResponseDto {
    private Long id;
    private String busNumber;
    private String status;
    private Long routeId;
    private String routeName;

}

