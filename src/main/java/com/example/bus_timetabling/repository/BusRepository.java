package com.example.bus_timetabling.repository;

import com.example.bus_timetabling.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {

    List<Bus> retrieveAllBuses();
}
