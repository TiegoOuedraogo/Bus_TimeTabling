package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.BusRequestDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.dto.RouteWithStopsDto;
import com.example.bus_timetabling.exception.ResourceNotFoundException;

import java.util.List;

public interface BusService {

    BusResponseDto findBusById(Long id) throws ResourceNotFoundException;

    List<BusResponseDto> findByBusNumber(String busNumber);

    List<BusResponseDto> getAllBuses();

    BusResponseDto createBus(BusRequestDto busRequestDto) throws ResourceNotFoundException;

    BusResponseDto updateBus(Long id, BusRequestDto busRequestDto) throws ResourceNotFoundException;

    void deleteBus(Long id) throws ResourceNotFoundException;

    RouteWithStopsDto getRouteWithStopsByBusId(Long id) throws ResourceNotFoundException;
}

