package com.example.bus_timetabling.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusDto {

    private Long id;
    @NotBlank(message = "Bus number is mandatory")
    private String busNumber;
    private String status;
    private Long routeId;
    private String routeName;

}

