package com.example.bus_timetabling.repository;

import com.example.bus_timetabling.dto.StopDto;
import com.example.bus_timetabling.entities.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {
    Stop findByStopName(String stopName);

}
