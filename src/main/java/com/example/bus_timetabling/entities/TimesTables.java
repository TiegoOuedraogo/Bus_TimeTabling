package com.example.bus_timetabling.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "times_tables")

public class TimesTables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "times_table_id", nullable = false)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
