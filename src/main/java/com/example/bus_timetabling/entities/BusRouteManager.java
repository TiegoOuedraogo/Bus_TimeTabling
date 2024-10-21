package com.example.bus_timetabling.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bus_route_manager", schema = "bus_timetabling")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class BusRouteManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_route_id")
    private Long id;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "bus_id")
    private Long bus_id;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "route_id")
    private Long route_id;
}
