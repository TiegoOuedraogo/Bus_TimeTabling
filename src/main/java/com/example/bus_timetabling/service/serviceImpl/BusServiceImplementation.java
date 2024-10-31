package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.*;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.entities.RouteStop;
import com.example.bus_timetabling.exception.ResourceNotFoundException;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.RouteRepository;
import com.example.bus_timetabling.repository.RouteStopRepository;
import com.example.bus_timetabling.service.BusService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class BusServiceImplementation implements BusService {

    private final BusRepository busRepository;
    private final RouteRepository routeRepository;
    private final RouteStopRepository routeStopRepository;

    public BusServiceImplementation(BusRepository busRepository, RouteRepository routeRepository, RouteStopRepository routeStopRepository) {
        this.busRepository = busRepository;
        this.routeRepository = routeRepository;
        this.routeStopRepository = routeStopRepository;
    }

    @Override
    public BusResponseDto findBusById(Long id) throws ResourceNotFoundException {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found with id " + id));
        return toResponseDto(bus);
    }

    @Override
    public List<BusResponseDto> findByBusNumber(String busNumber) {
        return busRepository.findByBusNumber(busNumber)
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BusResponseDto> getAllBuses() {
        return busRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public BusResponseDto createBus(BusRequestDto busRequestDto) throws ResourceNotFoundException {
        Bus bus = new Bus();
        bus.setBusNumber(busRequestDto.getBusNumber());
        bus.setStatus(busRequestDto.getStatus());

        if (busRequestDto.getRouteId() != null) {
            Route route = routeRepository.findById(busRequestDto.getRouteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Route not found with id " + busRequestDto.getRouteId()));
            bus.setRoute(route);
        }

        Bus savedBus = busRepository.save(bus);
        return toResponseDto(savedBus);
    }


    @Override
    public BusResponseDto updateBus(Long id, BusRequestDto busRequestDto) throws ResourceNotFoundException {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found with id " + id));

        bus.setBusNumber(busRequestDto.getBusNumber());
        bus.setStatus(busRequestDto.getStatus());

        if (busRequestDto.getRouteId() != null) {
            Route route = routeRepository.findById(busRequestDto.getRouteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Route not found with id " + busRequestDto.getRouteId()));
            bus.setRoute(route);
        } else {
            bus.setRoute(null);
        }

        Bus updatedBus = busRepository.save(bus);
        return toResponseDto(updatedBus);
    }

    @Override
    public void deleteBus(Long id) throws ResourceNotFoundException {
        if (!busRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bus not found with id " + id);
        }
        busRepository.deleteById(id);
    }

    @Override
    public RouteWithStopsDto getRouteWithStopsByBusId(Long busId) {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found with id " + busId));

        Route route = bus.getRoute();
        if (route == null) {
            throw new ResourceNotFoundException("Bus with id " + busId + " is not assigned to any route");
        }

        List<RouteStop> routeStops = routeStopRepository.findByRouteIdOrderByStopNum(route.getId());

        List<StopResponseDto> stops = routeStops.stream()
                .map(routeStop -> new StopResponseDto(
                        routeStop.getStop().getId(),
                        routeStop.getStop().getStopName()))
                .collect(Collectors.toList());

        return new RouteWithStopsDto(route.getId(), route.getRouteName(), stops);
    }

    // Mapping method
    private BusResponseDto toResponseDto(Bus bus) {
        return BusResponseDto.builder()
                .id(bus.getId())
                .busNumber(bus.getBusNumber())
                .status(bus.getStatus())
                .routeName(bus.getRoute().getRouteName())
                .build();
    }
}
