package com.example.bus_timetabling.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id", nullable = false)
    private Long id;

    @Column(name = "route_name", nullable = false)
    private String routeName;

    @Column(name = "origin", nullable = false)
    private String routeOrigin;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name="distance", nullable = false)
    private Double distance;

    // Relationships ///
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stop> stops =  new ArrayList<>();

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bus> buses = new ArrayList<>();

    public Route(Long id, String routeName, String destination, String routeOrigin, Double distance, List<Stop> stops, List<Bus> buses) {
        this.id = id;
        this.routeName = routeName;
        this.destination = destination;
        this.routeOrigin = routeOrigin;
        this.distance = distance;
        this.stops = stops;
        this.buses = buses;
    }

    public Route (){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getRouteOrigin() {
        return routeOrigin;
    }

    public void setRouteOrigin(String routeOrigin) {
        this.routeOrigin = routeOrigin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", routeName='" + routeName + '\'' +
                ", routeOrigin='" + routeOrigin + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                ", stops=" + stops +
                ", buses=" + buses +
                '}';
    }
}
