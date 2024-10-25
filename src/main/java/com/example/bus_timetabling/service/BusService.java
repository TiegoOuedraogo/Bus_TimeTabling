package com.example.bus_timetabling.service;

import com.example.bus_timetabling.entities.Bus;

import java.util.List;

public interface BusService {
    Bus findBusById(Long Id);
    List<Bus> findByBusNumber(String busNumber);
}
