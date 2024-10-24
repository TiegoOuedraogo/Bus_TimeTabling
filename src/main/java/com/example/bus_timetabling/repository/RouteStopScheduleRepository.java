package com.example.bus_timetabling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RouteStopScheduleRepository extends JpaRepository<Bus, Long> {
}
