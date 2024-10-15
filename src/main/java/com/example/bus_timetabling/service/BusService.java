package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.mapper.BusMapper;
import com.example.bus_timetabling.repository.BusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BusService {

    private final BusRepository busRepo;
    private final BusMapper busMapper;

    public BusService(BusRepository busRepo, BusMapper busMapper) {
        this.busRepo = busRepo;
        this.busMapper = busMapper;
    }

    public BusResponseDto findBusById(Long id) {
        return busRepo.findById(id)
                .map(busMapper::toBusResponseDto)
                .orElse(null);
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

    public List<BusResponseDto> findBusByRouteId(Long routeId) {
        return busRepo.findBusByRouteId(routeId).stream()
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

//    public boolean deleteBus(Long id) {
//        return busRepo.findById(id)
//                .map(bus -> {
//                    busRepo.delete(bus);
//                    return true;
//                })
//                .orElse(false);
//    }


//    public List<BusResponseDto> findBusByStopId(Long stopId) {
//        return busRepo.findBusByStopId(stopId).stream()
//                .map(busMapper::toBusResponseDto)
//                .collect(Collectors.toList());
//    }

}