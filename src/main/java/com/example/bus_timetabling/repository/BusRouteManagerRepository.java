package com.example.bus_timetabling.repository;

import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.BusRouteManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRouteManagerRepository extends JpaRepository<BusRouteManager, Long> {
}
