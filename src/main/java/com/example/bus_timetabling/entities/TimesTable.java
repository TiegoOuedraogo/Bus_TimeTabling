package com.example.bus_timetabling.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "times_tables", schema = "bus_timetabling")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TimesTable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "times_table_id")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "from_stop_id", nullable = false)
//    private Stop fromStop;
//
//    @ManyToOne
//    @JoinColumn(name = "to_stop_id", referencedColumnName = "stop_id", nullable = false)
//    private Stop toStop;
//
//    @Column(name = "departure")
//    private LocalTime departure;
//
//    @Column(name = "arrival")
//    private LocalTime arrival;
//
//    @ManyToOne
//    @JoinColumn(name = "bus_id", nullable = false)
//    private Bus bus;
//

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "times_table_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "stop_id", nullable = false)
    private Stop stop;

    @Column(name = "arrival")
    private LocalTime arrival;

    @Column(name = "departure")
    private LocalTime departure;






}
