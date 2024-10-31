package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.CustomDto;
import com.example.bus_timetabling.dto.TimetableRequestDto;
import com.example.bus_timetabling.dto.TimetableResponseDto;
import com.example.bus_timetabling.exception.ResourceNotFoundException;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public interface TimetableService {

    List<TimetableResponseDto> getAllTimetables();

    TimetableResponseDto getTimetableById(Long id) throws ResourceNotFoundException;

    TimetableResponseDto createTimetable(TimetableRequestDto requestDto);

    TimetableResponseDto updateTimetable(Long id, TimetableRequestDto requestDto) throws ResourceNotFoundException;

    void deleteTimetable(Long id) throws ResourceNotFoundException;

    CustomDto findNextBusForRoute(Long stopId, LocalTime currentTime);

    List<CustomDto> findNextThreeBusesAtStop(Long stopId, LocalTime currentTime);

    Duration calculateTravelTime(Long stopX, Long stopY);
}
