package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.StopDto;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.mapper.StopMapper;
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

    public StopDto findStopById(Long id) {
        return stopRepo.findById(id)
                .map(stopMapper::toStopDto)
                .orElse(null);
    }

    public List<StopDto> findStopByName(String stopName) {
        return stopRepo.findByStopName(stopName).stream()
                .map(stopMapper::toStopDto)
                .collect(Collectors.toList());
    }

    public List<StopDto> findAllStops() {
        return stopRepo.findAll().stream()
                .map(stopMapper::toStopDto)
                .collect(Collectors.toList());
    }

//    public List<StopDto> findStopByRouteId(Long routeId) {
//        return stopRepo.findStopByRouteId(routeId).stream()
//                .map(stopMapper::toStopDto)
//                .collect(Collectors.toList());
//    }

    public void createStop(StopDto stopDto) {
        Stop stop = stopMapper.toStop(stopDto);
        stopRepo.save(stop);
    }

    public StopDto updateBus(Long id, StopDto stopDto) {
        return stopRepo.findById(id)
                .map(existingBus -> {
                    Stop updatedStop = stopMapper.toStop(stopDto);
                    updatedStop.setId(id);
                    return stopMapper.toStopDto(stopRepo.save(updatedStop));
                })
                .orElse(null);
    }
}
