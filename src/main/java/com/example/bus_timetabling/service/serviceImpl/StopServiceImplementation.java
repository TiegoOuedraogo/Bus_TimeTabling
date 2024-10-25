package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.StopDto;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.mapper.StopMapper;
import com.example.bus_timetabling.repository.StopRepository;
import com.example.bus_timetabling.service.StopService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StopServiceImplementation implements StopService {
    private final StopRepository stopRepo;
    private final StopMapper stopMapper;

    public StopServiceImplementation(StopRepository stopRepo, StopMapper stopMapper) {
        this.stopRepo = stopRepo;
        this.stopMapper = stopMapper;
    }

    public StopDto findByStopId(Long id) {
        Stop stop = stopRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Stop not found"));
        return convertToStopDto(stop);
    }

    public StopDto findByStopName(String stopName) {
        Stop stop = stopRepo.findByStopName(stopName);
        return convertToStopDto(stop);

    }

    public List<StopDto> findAllStops() {
        return stopRepo.findAll().stream()
                .map(this::convertToStopDto)
                .collect(Collectors.toList());
    }

    public void createStop(StopDto stopDto) {
        stopRepo.save(convertToStopEntity(stopDto));
    }

    public void updateBus(Long id, StopDto stopDto) {
        Stop stop = stopRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Stop not found"));
        stopRepo.save(convertToStopEntity(stopDto));
    }

    public StopDto convertToStopDto(Stop stop) {
        StopDto dto = new StopDto();
        dto.setId(stop.getId());
        dto.setStopName(stop.getStopName());

        return dto;
    }

    public Stop convertToStopEntity(StopDto dto) {
        if(dto == null) {
            return null;
        }
        Stop stop = new Stop();
        stop.setId(dto.getId());
        stop.setStopName(dto.getStopName());
        return stop;
    }
}
