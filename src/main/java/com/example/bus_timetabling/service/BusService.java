package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.dto.BusRequestDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.mapper.BusMapper;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.RouteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BusService {

    private final BusRepository busRepository;
    private final RouteRepository routeRepository;
    private final BusMapper busMapper;

    public BusService(BusRepository busRepository, RouteRepository routeRepository, BusMapper busMapper) {
        this.busRepository = busRepository;
        this.routeRepository = routeRepository;
        this.busMapper = busMapper;
    }

    public BusResponseDto createBus(BusRequestDto busRequestDto) {
        Bus bus = busMapper.toBus(busRequestDto);
        Route route = routeRepository.findById(busRequestDto.getRouteId())
                .orElseThrow(() -> new RuntimeException("Route not found"));
        bus.setRoute(route);
        Bus savedBus = busRepository.save(bus);
        return busMapper.toBusResponseDto(savedBus);
    }

    public BusResponseDto getBusById(Long id) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found"));
        return busMapper.toBusResponseDto(bus);
    }

    public List<BusResponseDto> getAllBuses() {
        return busRepository.findAll().stream()
                .map(busMapper::toBusResponseDto)
                .collect(Collectors.toList());
    }

    public BusResponseDto updateBus(Long id, BusRequestDto busRequestDto) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found"));

        bus.setBusNumber(busRequestDto.getBusNumber());
//        bus.setCapacity(busRequestDto.getCapacity());
        bus.setStatus(busRequestDto.getStatus());

        if (!bus.getRoute().getId().equals(busRequestDto.getRouteId())) {
            Route newRoute = routeRepository.findById(busRequestDto.getRouteId())
                    .orElseThrow(() -> new RuntimeException("Route not found"));
            bus.setRoute(newRoute);
        }

        Bus updatedBus = busRepository.save(bus);
        return busMapper.toBusResponseDto(updatedBus);
    }

    public void deleteBus(Long id) {
        if (!busRepository.existsById(id)) {
            throw new RuntimeException("Bus not found");
        }
        busRepository.deleteById(id);
    }

    public List<BusResponseDto> getBusByNumber(String busNumber) {
        List<Bus> buses = busRepository.findByBusNumber(busNumber);
        return buses.stream()
               .map(busMapper::toBusResponseDto)
               .collect(Collectors.toList());
    }

    public List<BusResponseDto> findBusByRouteId(Long routeId) {
        List<Bus> buses = busRepository.findBusByRouteId(routeId);
        return buses.stream()
               .map(busMapper::toBusResponseDto)
               .collect(Collectors.toList());
    }
}