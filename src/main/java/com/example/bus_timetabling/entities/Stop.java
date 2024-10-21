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

//    @Column(name = "order_in_route")
//    private Integer orderInRoute;
//
//    @ManyToOne
//    @JoinColumn(name = "route_id", referencedColumnName = "route_id")
//    private Route route;
//
//    @OneToMany(mappedBy = "fromStop", cascade = CascadeType.ALL)
//    private List<TimesTable> departureTimesTables = new ArrayList<>();
//
//    @OneToMany(mappedBy = "toStop", cascade = CascadeType.ALL)
//    private List<TimesTable> arrivalTimesTables = new ArrayList<>();
}

