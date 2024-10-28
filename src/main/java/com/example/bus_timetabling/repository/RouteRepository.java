package com.example.bus_timetabling.repository;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
   RouteDto findRouteByRouteName(String routeName);

}
