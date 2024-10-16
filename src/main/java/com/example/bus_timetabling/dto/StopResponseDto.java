package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.entities.TimesTable;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class StopResponseDto {
    private Long id;
    private String stopName;
    private RouteDto route;
//    private List<TimesTable> timesTables = new ArrayList<>();
    private List<TimesTableDto> timesTables = new ArrayList<>();
}
