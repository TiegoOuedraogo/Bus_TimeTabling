package com.example.bus_timetabling.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class RouteRequestDto {
    @NotBlank
    private String routeName;

    private Double distance;
}

