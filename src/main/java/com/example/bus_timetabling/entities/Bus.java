package com.example.bus_timetabling.entities;

import com.example.bus_timetabling.enums.ServiceStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buses", schema = "bus_timetabling")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long id;

    @Column(name = "number")
    private String busNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ServiceStatus status;

    // Relationships
    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimesTable> timesTables = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "to_stop_id") //defaults to primary key of Stop
    private Stop toStop;

    @ManyToOne
    @JoinColumn(name = "from_stop_id") //defaults to primary key of Stop
    private Stop fromStop;

    @ManyToOne
    @JoinColumn(name = "route_schedule_id") //defaults to primary key of BusRouteManager
    private BusRouteManager busRouteManager;
}
