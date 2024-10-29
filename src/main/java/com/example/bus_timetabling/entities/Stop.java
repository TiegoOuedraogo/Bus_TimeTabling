package com.example.bus_timetabling.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table(name="stops", schema = "bus_timetabling")

public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stop_id")
    private Long id;

    @Column(name = "stop_name")
    private String stopName;

    @ManyToOne
    @JoinColumn(name = "route_stop_id") // Defaults to primary key of RouteStopSchedule
    private RouteStopSchedule routeStopSchedule;
}