package com.example.bus_timetabling.repository;

import com.example.bus_timetabling.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    Bus findBusById(Long Id);
    List<Bus> findBusByRouteId(Long Id);
    List<Bus> findByBusNumber(String busNumber);
//    List<Bus> findBusByStopId(Long Id);
}
