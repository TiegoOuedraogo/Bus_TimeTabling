package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Stop;
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
public class RouteDto {
    private Long id;
    private String routeName;
    private String routeOrigin;
    private String destination;
    private Double distance;
    private List<StopDto> stops;
    private List<BusDto> buses ;

}
