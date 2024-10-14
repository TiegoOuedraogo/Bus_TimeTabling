package com.example.bus_timetabling.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "routes")
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routes_id", nullable = false)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
