package com.example.bus_timetabling.entities;

import jakarta.persistence.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Table(name = "buses")
public class Buses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id", nullable = false )
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
