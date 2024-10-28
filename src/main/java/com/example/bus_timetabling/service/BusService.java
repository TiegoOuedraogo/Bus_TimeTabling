package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.entities.Bus;

import java.util.List;

public interface BusService {
    BusDto findBusById(Long Id);
}
