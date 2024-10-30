package com.example.bus_timetabling.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class RouteStopId implements Serializable {

    private Long routeId;
    private Long stopId;

}

