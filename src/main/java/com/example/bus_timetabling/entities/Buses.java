package com.example.bus_timetabling.entities;

import com.example.bus_timetabling.enums.Service;
import jakarta.persistence.*;
import org.springframework.util.RouteMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Table(name = "buses")
public class Buses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id", nullable = false )
    private Long id;

    @Column(name = "number", nullable = false)
    private Integer bus_number;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "status", nullable = false)
    private Service status;

    //Relationships
    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimesTables> timesTables = new ArrayList<TimesTables>();

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Routes route;

}
