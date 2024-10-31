package com.example.bus_timetabling.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "stops", schema = "bus_timetabling")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stop_id")
    private Long id;

    @Column(name = "stop_name")
    private String stopName;

    // Relationship with RouteStop
    @OneToMany(mappedBy = "stop", cascade = CascadeType.ALL)
    private List<RouteStop> routeStops = new ArrayList<>();

    // Relationship with Timetable
    @OneToMany(mappedBy = "stop", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Timetable> timetables;
}


