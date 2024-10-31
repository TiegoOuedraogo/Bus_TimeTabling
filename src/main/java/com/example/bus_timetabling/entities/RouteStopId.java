package com.example.bus_timetabling.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
@Setter
@Getter
@ToString
@EqualsAndHashCode

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RouteStopId implements Serializable {

    @Column(name = "route_id")
    private Long routeId;

    @Column(name = "stop_id")
    private Long stopId;


    public RouteStopId() {}

    public RouteStopId(Long routeId, Long stopId) {
        this.routeId = routeId;
        this.stopId = stopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteStopId that = (RouteStopId) o;

        return Objects.equals(routeId, that.routeId) &&
                Objects.equals(stopId, that.stopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, stopId);
    }

}
