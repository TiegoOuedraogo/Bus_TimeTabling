package com.example.bus_timetabling.repository;

import com.example.bus_timetabling.entities.RouteStop;
import com.example.bus_timetabling.entities.RouteStopId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RouteStopRepository extends JpaRepository<RouteStop, RouteStopId> {

    List<RouteStop> findByRouteIdOrderByStopNum(Long id);
}
