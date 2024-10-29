package com.example.bus_timetabling.repository;

import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.entities.TimesTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TimesTableRepository extends JpaRepository<TimesTable, Long> {

    @Query(value = "SELECT * FROM bus_timetabling.times_tables " +
            "WHERE to_stop_id = :stopId AND arrival > :currentTime " +
            "ORDER BY arrival ASC " +
            "LIMIT 3", nativeQuery = true)
    List<TimesTable> findNextThreeBusesAtStop(@Param("stopId") Long stopId, @Param("currentTime") LocalTime currentTime);

    @Query(value = "SELECT * FROM bus_timetabling.times_tables " +
            "WHERE :stopId = to_stop_id AND departure > :currentTime " +
            "ORDER BY departure ASC " +
            "LIMIT 1", nativeQuery = true)
    Optional<TimesTable> findNextBusForRoute(@Param("stopId") Long stopId, @Param("currentTime") LocalTime currentTime);

    @Query(value = "SELECT t FROM TimesTable t WHERE t.fromStop = :stopX OR t.toStop = :stopY ORDER BY t.departure ASC")
    List<TimesTable> findSchedulesForStops(@Param("stopX") Stop stopX, @Param("stopY") Stop stopY);
}



