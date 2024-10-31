package com.example.bus_timetabling.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "route_stops", schema = "bus_timetabling")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class RouteStop implements Serializable {

    @EmbeddedId
    private RouteStopId id;

    @ManyToOne
    @MapsId("routeId")
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne
    @MapsId("stopId")
    @JoinColumn(name = "stop_id")
    private Stop stop;

    @Column(name = "stop_num", nullable = false)
    private Integer stopNum;
}
