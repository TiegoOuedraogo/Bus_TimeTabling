package com.example.bus_timetabling.entities;

import com.example.bus_timetabling.enums.Service;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buses")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id", nullable = false )
    private Long id;

    @Column(name = "number", nullable = false)
    private String busNumber;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "status", nullable = false)
    private Service status;

    //Relationships
    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimesTable> timesTables = new ArrayList<TimesTable>();

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

}
