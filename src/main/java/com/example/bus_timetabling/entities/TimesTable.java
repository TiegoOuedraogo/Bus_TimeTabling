//package com.example.bus_timetabling.entities;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@ToString
//@Builder
//@Entity
//
//@Table(name = "times_tables", schema = "bus_timetabling")
//@Data
//
//public class TimesTable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "times_table_id")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "from_stop_id",nullable = false) // Defaults to primary key of Stop
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
//    @JoinColumn(name = "bus_id") // Defaults to primary key of Bus
//    private Bus bus;
//
//    @OneToMany(mappedBy = "timestables", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Bus> buses = new ArrayList<>();
//
//}


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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "times_table_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_stop_id", nullable = false)
    private Stop fromStop;

    @ManyToOne
    @JoinColumn(name = "to_stop_id", referencedColumnName = "stop_id", nullable = false)
    private Stop toStop;

    @Column(name = "departure")
    private LocalTime departure;

    @Column(name = "arrival")
    private LocalTime arrival;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;
}
