package com.example.bus_timetabling.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long id;

    @Column(name = "route_name")
    private String routeName;

    @Column(name = "origin")
    private String routeOrigin;

    @Column(name = "destintion", nullable = false)
    private String destination;

    @Column(name="distance")
    private Double distance;

    // Relationships
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stop> stops = new ArrayList<>();

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bus> buses = new ArrayList<>();
}
