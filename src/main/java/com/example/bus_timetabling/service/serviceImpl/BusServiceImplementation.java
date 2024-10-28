package com.example.bus_timetabling.service.serviceImpl;


import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.service.BusService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class BusServiceImplementation implements BusService {

    private final BusRepository busRepo;

    public BusServiceImplementation(BusRepository busRepo) {
        this.busRepo = busRepo;
    }

    public BusResponseDto findBusById(Long id) {
        return busRepo.findById(id).map(this::toDto).map(this::toResponseDto).orElse(null);
    }

    public List<BusResponseDto> findByBusNumber(String busNumber) {
        return busRepo.findByBusNumber(busNumber).stream().map(this::toResponseDto).collect(Collectors.toList());
    }

    public List<BusResponseDto> getAllBuses() {
        return busRepo.findAll().stream().map(this::toDto).map(this::toResponseDto).collect(Collectors.toList());
    }

    public BusDto toDto(Bus bus) {
        BusDto dto = new BusDto();
        dto.setId(bus.getId());
        dto.setBus_Route(bus.getBusRouteManager());
        dto.setStatus(bus.getStatus());
//        dto.setToStop(bus.getToStop());
//        dto.setFromStop(bus.getFromStop());
        dto.setBusNumber(bus.getBusNumber());
        return dto;
    }

    public BusResponseDto toResponseDto(BusDto dto) {
        BusResponseDto newDto = new BusResponseDto();
        newDto.setId(dto.getId());
        newDto.setBusNumber(dto.getBusNumber());
        newDto.setStatus(dto.getStatus());
        return newDto;
    }

}