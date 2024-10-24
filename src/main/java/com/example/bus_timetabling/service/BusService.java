package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.dto.BusRequestDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.mapper.BusMapper;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.RouteRepository;
//import org.springframework.stereotype.ServiceStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

//@ServiceStatus
@Transactional
@Service
public class BusService {

    private final BusRepository busRepo;
    private final BusMapper busMapper;

    public BusService(BusRepository busRepo, BusMapper busMapper, RouteRepository routeRepo) {
        this.busRepo = busRepo;
        this.busMapper = busMapper;
    }

    public List<BusResponseDto> findBusByNumber(String busNumber) {
        return busRepo.findByBusNumber(busNumber).stream()
                .map(busMapper::toBusResponseDto)
                .collect(Collectors.toList());
    }

    public List<BusResponseDto> getAllBuses() {
        return busRepo.findAll().stream()
                .map(busMapper::toBusResponseDto)
                .collect(Collectors.toList());
    }

    public BusResponseDto createBus(BusDto busDto) {
        Bus bus = busMapper.toBus(busDto);
        Bus savedBus = busRepo.save(bus);
        return busMapper.toBusResponseDto(savedBus);
    }

    public BusResponseDto updateBus(Long id, BusDto busDto) {
        return busRepo.findById(id)
                .map(existingBus -> {
                    Bus updatedBus = busMapper.toBus(busDto);
                    updatedBus.setId(id);
                    return busMapper.toBusResponseDto(busRepo.save(updatedBus));
                })
                .orElse(null);
    }

    public BusResponseDto findBusById(Long id) {
        return busRepo.findById(id).map(busMapper::toBusResponseDto).orElse(null);
    }

}