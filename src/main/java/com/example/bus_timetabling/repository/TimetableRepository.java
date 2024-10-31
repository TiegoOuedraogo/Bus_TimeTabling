//package com.example.bus_timetabling.repository;
//
//import com.example.bus_timetabling.entities.Stop;
//import com.example.bus_timetabling.entities.Timetable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalTime;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface TimetableRepository extends JpaRepository<Timetable, Long> {
//
//    @Query(value = "SELECT * FROM bus_timetabling.times_tables " +
//            "WHERE to_stop_id = :stopId AND arrival > :currentTime " +
//            "ORDER BY arrival ASC " +
//            "LIMIT 3", nativeQuery = true)
//    List<Timetable> findNextThreeBusesAtStop(@Param("stopId") Long stopId, @Param("currentTime") LocalTime currentTime);
//
//    @Query(value = "SELECT * FROM bus_timetabling.times_tables " +
//            "WHERE :stopId = to_stop_id AND departure > :currentTime " +
//            "ORDER BY departure ASC " +
//            "LIMIT 1", nativeQuery = true)
//    Optional<Timetable> findNextBusForRoute(@Param("stopId") Long stopId, @Param("currentTime") LocalTime currentTime);
//
//    @Query(value = "SELECT t FROM Timetable t WHERE t.fromStop = :stopX OR t.toStop = :stopY ORDER BY t.departure ASC")
//    List<Timetable> findSchedulesForStops(@Param("stopX") Stop stopX, @Param("stopY") Stop stopY);
//}
//
//
//



package com.example.bus_timetabling.repository;

import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.entities.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    @Query("SELECT t FROM Timetable t WHERE t.stop.id = :stopId AND t.arrival > :currentTime ORDER BY t.arrival ASC LIMIT 3")
    List<Timetable> findNextThreeBusesAtStop(Long stopId, LocalTime currentTime);

    @Query("SELECT t FROM Timetable t WHERE t.stop.id = :stopId AND t.departure > :currentTime ORDER BY t.departure ASC LIMIT 1")
    Optional<Timetable> findNextBusForRoute(Long stopId, LocalTime currentTime);

    @Query("SELECT t FROM Timetable t WHERE t.stop = :stopX OR t.stop = :stopY ORDER BY t.departure ASC")
    List<Timetable> findSchedulesForStops(Stop stopX, Stop stopY);
}
