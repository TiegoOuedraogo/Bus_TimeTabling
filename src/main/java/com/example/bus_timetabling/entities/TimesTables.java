package com.example.bus_timetabling.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "times_tables")

public class TimesTables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "times_table_id", nullable = false)
    private Long id;

    @Column(name = "departures", nullable = false)
    private LocalDate departures;

    @Column(name = "arrival", nullable = false)
    private LocalDate arrival;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Buses bus;

    @ManyToOne
    @JoinColumn(name = "stop_id", nullable = false)
    private Stop stop;

}
