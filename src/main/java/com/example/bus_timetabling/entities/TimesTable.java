package com.example.bus_timetabling.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "times_tables", schema = "bus_timetabling")
@Data
public class TimesTable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "times_table_id")
//    private Long id;
    @Id
    @ManyToOne
    @JoinColumn(name = "from_stop_id")
    private Stop fromStop;

    @Id
    @ManyToOne
    @JoinColumn(name = "to_stop_id")
    private Stop toStop;

    @Column(name = "departure")
    private LocalTime departure;

    @Column(name = "arrival")
    private LocalTime arrival;

//    @Column(name = "segment_distance")
//    private Double segmentDistance;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Long busId;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Long routeId;

}