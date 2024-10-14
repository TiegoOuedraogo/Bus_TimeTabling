package com.example.bus_timetabling.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stops")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stop_id", nullable = false )
    private Long id;

    @Column(name = "stop_name", nullable = false)
    private String stopName;

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "routes_id")
    private Routes routes;

    @OneToMany(mappedBy ="stop", cascade= CascadeType.ALL)
    private List<TimesTables> timesTables;
}
