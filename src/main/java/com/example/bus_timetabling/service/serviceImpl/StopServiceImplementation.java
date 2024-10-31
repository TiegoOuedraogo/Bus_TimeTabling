package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.StopRequestDto;
import com.example.bus_timetabling.dto.StopResponseDto;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.exception.ResourceNotFoundException;
import com.example.bus_timetabling.repository.StopRepository;
import com.example.bus_timetabling.service.StopService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StopServiceImplementation implements StopService {

    private final StopRepository stopRepository;

    public StopServiceImplementation(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    @Override
    public StopResponseDto findByStopId(Long id) throws ResourceNotFoundException {
        Stop stop = stopRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stop not found with id " + id));
        return toResponseDto(stop);
    }

    @Override
    public StopResponseDto findByStopName(String stopName) throws ResourceNotFoundException {
        Stop stop = stopRepository.findByStopName(stopName);
        if (stop == null) {
            throw new ResourceNotFoundException("Stop not found with name " + stopName);
        }
        return toResponseDto(stop);
    }

    @Override
    public List<StopResponseDto> findAllStops() {
        return stopRepository.findAll().stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public StopResponseDto createStop(StopRequestDto stopRequestDto) {
        Stop stop = new Stop();
        stop.setStopName(stopRequestDto.getStopName());
        Stop savedStop = stopRepository.save(stop);
        return toResponseDto(savedStop);
    }

    @Override
    public StopResponseDto updateStop(Long id, StopRequestDto stopRequestDto) throws ResourceNotFoundException {
        Stop stop = stopRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stop not found with id " + id));
        stop.setStopName(stopRequestDto.getStopName());
        Stop updatedStop = stopRepository.save(stop);
        return toResponseDto(updatedStop);
    }

    @Override
    public void deleteStop(Long id) throws ResourceNotFoundException {
        if (!stopRepository.existsById(id)) {
            throw new ResourceNotFoundException("Stop not found with id " + id);
        }
        stopRepository.deleteById(id);
    }

    private StopResponseDto toResponseDto(Stop stop) {
        StopResponseDto dto = new StopResponseDto();
        dto.setId(stop.getId());
        dto.setStopName(stop.getStopName());
        return dto;
    }
}
