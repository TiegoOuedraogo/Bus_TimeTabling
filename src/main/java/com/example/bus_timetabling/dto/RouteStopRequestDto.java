package com.example.bus_timetabling.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class RouteStopRequestDto {
    @NotNull
    private Long routeId;

    @NotNull
    private Long stopId;

    @NotNull
    private Integer stopNum;
}
