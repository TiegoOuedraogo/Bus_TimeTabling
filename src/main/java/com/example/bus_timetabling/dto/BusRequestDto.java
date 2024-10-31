package com.example.bus_timetabling.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BusRequestDto {

    @NotBlank
    private String busNumber;

    @NotBlank
    private String status;

    private Long routeId;
}

