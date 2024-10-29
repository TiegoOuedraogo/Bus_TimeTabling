package com.example.bus_timetabling.repository;

import com.example.bus_timetabling.entities.TimesTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Repository
public interface TimesTableRepository extends JpaRepository<TimesTable, Long> {

    @Query(value = "SELECT * FROM bus_timetabling.times_tables " +
            "WHERE to_stop_id = :stopId AND arrival > :currentTime " +
            "ORDER BY arrival ASC " +
            "LIMIT 3", nativeQuery = true)
    List<TimesTable> findNextThreeBusesAtStop(@Param("stopId") Long stopId, @Param("currentTime") LocalTime currentTime);
}


