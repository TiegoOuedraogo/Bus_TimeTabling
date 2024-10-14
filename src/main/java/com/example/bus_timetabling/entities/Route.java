package com.example.bus_timetabling.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routes_id", nullable = false)
    private Long id;

    @Column(name = "route_name", nullable = false)
    private String routeName;

    @Column(name = "origin", nullable = false)
    private String routeOrigin;

    @Column(name = "destintion", nullable = false)
    private String destination;

    @Column(name="distance", nullable = false)
    private Double distance;

    // Relationships ///
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stop> stops =  new ArrayList<>();

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bus> buses;

}
