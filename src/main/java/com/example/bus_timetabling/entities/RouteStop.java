package com.example.bus_timetabling.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "route_stop_schedule",  schema = "bus_timetabling")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder


public class RouteStop implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "route_stop_id", nullable = false)
//    private Long id;
//
//    @Column(name = "stop_num")
//    private int stopNum;
//    @Column(name = "stop_route")
//
//    @OneToMany(mappedBy = "routeStopSchedule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<Stop> stops;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "route_id")
//    private Route route;

    @EmbeddedId
    private RouteStopId id;

    @ManyToOne
    @MapsId("routeId")
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne
    @MapsId("stopId")
    @JoinColumn(name = "stop_id")
    private Stop stop;

    @Column(name = "stop_num", nullable = false)
    private Integer stopNum;
}

