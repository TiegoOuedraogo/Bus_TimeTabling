package com.example.bus_timetabling.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity

@Table(name = "times_tables", schema = "bus_timetabling")
@Data

public class TimesTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "times_table_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_stop_id") // Defaults to primary key of Stop
    private Stop fromStop;

    @ManyToOne
    @JoinColumn(name = "to_stop_id") // Defaults to primary key of Stop
    private Stop toStop;

    @Column(name = "departure")
    private LocalTime departure;

    @Column(name = "arrival")
    private LocalTime arrival;

    @ManyToOne
    @JoinColumn(name = "bus_id") // Defaults to primary key of Bus
    private Bus bus;

}
