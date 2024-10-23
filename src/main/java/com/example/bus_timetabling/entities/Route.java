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

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RouteStopSchedule> routeStopSchedules = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "bus_route_id")
    private BusRouteManager busRouteManager;
}