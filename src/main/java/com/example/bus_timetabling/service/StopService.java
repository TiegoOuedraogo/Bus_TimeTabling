package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.StopDto;
import com.example.bus_timetabling.entities.Stop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StopService {
    StopDto findByStopId(Long id);

    StopDto findByStopName(String stopName);

    List<StopDto> findAllStops();

    void createStop(StopDto stopDto);

    void updateBus(Long id, StopDto stopDto);

}
