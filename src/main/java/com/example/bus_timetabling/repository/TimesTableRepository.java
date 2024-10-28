package com.example.bus_timetabling.repository;

import com.example.bus_timetabling.entities.TimesTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Repository
public interface TimesTableRepository extends JpaRepository<TimesTable, Long> {
    @Query("SELECT s FROM TimesTable s WHERE s.toStop.id = :stopId AND s.arrival > :currentTime ORDER BY s.arrival ASC")
    List<TimesTable> findNextThreeBusesAtStop(@Param("stopId") Long stopId, @Param("currentTime") LocalTime currentTime);


}
