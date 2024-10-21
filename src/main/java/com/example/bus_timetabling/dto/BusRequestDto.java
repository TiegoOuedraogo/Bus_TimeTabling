package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.enums.Service;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BusRequestDto {
    private String busNumber;
    private Service status;
    private Long routeId;
}