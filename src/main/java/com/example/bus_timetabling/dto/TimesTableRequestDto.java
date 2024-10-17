package com.example.bus_timetabling.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

public class TimesTableRequestDto {

    private LocalTime departure;

    private LocalTime arrival;

    @NotNull(message = "Bus ID cannot be null")
    private Long busId;

    @NotNull(message = "From Stop ID cannot be null")
    private Long fromStopId;

    @NotNull(message = "To Stop ID cannot be null")
    private Long toStopId;


    public void validateTimes() {
        if (departure != null && arrival != null && !departure.isBefore(arrival)) {
            throw new IllegalArgumentException("Departure time must be before arrival time.");
        }
    }

}

