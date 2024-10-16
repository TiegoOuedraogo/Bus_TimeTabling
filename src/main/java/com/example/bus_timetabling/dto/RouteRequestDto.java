package com.example.bus_timetabling.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class RouteRequestDto {
    private String routeName;
    private String busNumber;
}
