package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.entities.Bus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BusService {
    BusResponseDto findBusById(Long Id);
}
