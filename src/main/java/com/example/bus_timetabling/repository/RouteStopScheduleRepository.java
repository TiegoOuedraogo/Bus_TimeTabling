package com.example.bus_timetabling.repository;

import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.RouteStopSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteStopScheduleRepository extends JpaRepository<RouteStopSchedule, Long> {
}
