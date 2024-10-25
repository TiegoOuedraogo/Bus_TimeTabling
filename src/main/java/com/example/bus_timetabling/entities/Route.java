package com.example.bus_timetabling.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes", schema = "bus_timetabling")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long id;

    @Column(name = "route_name")
    private String routeName;

    @Column(name = "distance")
    private Double distance;

    @ManyToOne
    @JoinColumn(name = "route_stop_id")
    private RouteStopSchedule routeStopSchedules;

    @ManyToOne
    @JoinColumn(name = "bus_route_id")
    private BusRouteManager busRouteManager;
}