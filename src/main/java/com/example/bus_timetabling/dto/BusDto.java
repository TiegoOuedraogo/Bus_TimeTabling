package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.enums.Service;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class BusDto {
    private Long id;
    private String busNumber;
    private Integer capacity;
    private Service status;
    private RouteDto route;
    private List<TimesTableDto> timesTables;
}