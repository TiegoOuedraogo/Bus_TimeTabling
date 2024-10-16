package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.dto.StopDto;
import com.example.bus_timetabling.dto.StopResponseDto;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.mapper.BusMapper;
import com.example.bus_timetabling.mapper.StopMapper;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StopService {
    private final StopRepository stopRepo;
    private final StopMapper stopMapper;

    public StopService(StopRepository stopRepo, StopMapper stopMapper) {
        this.stopRepo = stopRepo;
        this.stopMapper = stopMapper;
    }

    public StopResponseDto findStopById(Long id) {
        return stopRepo.findById(id)
                .map(stopMapper::toStopResponseDto)
                .orElse(null);
    }

    public List<StopResponseDto> findStopByName(String stopName) {
        return stopRepo.findByStopName(stopName).stream()
                .map(stopMapper::toStopResponseDto)
                .collect(Collectors.toList());
    }

    public List<StopResponseDto> findAllStops() {
        return stopRepo.findAll().stream()
                .map(stopMapper::toStopResponseDto)
                .collect(Collectors.toList());
    }

    public List<StopResponseDto> findBusByRouteId(Long routeId) {
        return stopRepo.findStopByRouteId(routeId).stream()
                .map(stopMapper::toStopResponseDto)
                .collect(Collectors.toList());
    }

    public StopResponseDto createStop(StopDto stopDto) {
        Stop stop = stopMapper.toStop(stopDto);
        Stop savedStop = stopRepo.save(stop);
        return stopMapper.toStopResponseDto(savedStop);
    }

    public StopResponseDto updateBus(Long id, StopDto stopDto) {
        return stopRepo.findById(id)
                .map(existingBus -> {
                    Stop updatedStop = stopMapper.toStop(stopDto);
                    updatedStop.setId(id);
                    return stopMapper.toStopResponseDto(stopRepo.save(updatedStop));
                })
                .orElse(null);
    }
}
