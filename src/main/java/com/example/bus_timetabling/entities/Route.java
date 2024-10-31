package com.example.bus_timetabling.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes", schema = "bus_timetabling")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long id;

    @Column(name = "route_name")
    private String routeName;

    @Column(name = "distance")
    private Double distance;

    // Relationship with RouteStop
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RouteStop> routeStops = new ArrayList<>();

    // Relationship with Bus
    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bus> buses = new ArrayList<>();
}
