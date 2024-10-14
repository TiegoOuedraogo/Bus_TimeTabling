package com.example.bus_timetabling.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "times_tables")

public class TimesTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "times_table_id", nullable = false)
    private Long id;

    @Column(name = "departures", nullable = false)
    private LocalDateTime departures;

    @Column(name = "arrival", nullable = false)
    private LocalDateTime arrival;
        //Relationship
    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "stop_id", nullable = false)
    private Stop stop;

}
