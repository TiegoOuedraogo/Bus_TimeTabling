package com.example.bus_timetabling.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buses", schema = "bus_timetabling")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Builder

public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long id;

    @Column(name = "bus_number", nullable = false)
    private String busNumber;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Timetable> timetables = new ArrayList<>();

}
