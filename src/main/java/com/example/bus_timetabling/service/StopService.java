package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.StopRequestDto;
import com.example.bus_timetabling.dto.StopResponseDto;
import com.example.bus_timetabling.exception.ResourceNotFoundException;

import java.util.List;

public interface StopService {

    StopResponseDto findByStopId(Long id) throws ResourceNotFoundException;

    StopResponseDto findByStopName(String stopName) throws ResourceNotFoundException;

    List<StopResponseDto> findAllStops();

    StopResponseDto createStop(StopRequestDto stopRequestDto);

    StopResponseDto updateStop(Long id, StopRequestDto stopRequestDto) throws ResourceNotFoundException;

    void deleteStop(Long id) throws ResourceNotFoundException;
}
