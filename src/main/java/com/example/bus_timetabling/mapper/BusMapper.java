package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.dto.BusRequestDto;
import com.example.bus_timetabling.entities.Bus;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BusMapper {

    private final TimesTableMapper timesTableMapper;

    public BusMapper(RouteMapper routeMapper, TimesTableMapper timesTableMapper) {
        this.timesTableMapper = timesTableMapper;
    }

    public Bus toBus(BusDto dto) {
        if(dto == null) {
            return null;
        }

        Bus bus = new Bus();
        bus.setId(dto.getId());
        bus.setBusNumber(dto.getBusNumber());
        bus.setStatus(dto.getStatus());
        bus.setFromStop(dto.getFromStop());
        bus.setToStop(dto.getToStop());
        bus.setBusRouteManager(dto.getBus_Route());
        return bus;
    }

    public Bus toBus(BusRequestDto dto) {
        if(dto == null) {
            return null;
        }

        Bus bus = new Bus();
        bus.setBusNumber(dto.getBusNumber());
        return bus;
    }

    public BusResponseDto toBusResponseDto(Bus bus) {
        if (bus == null) {
            return null;
        }

        return BusResponseDto.builder()
                .id(bus.getId())
                .busNumber(bus.getBusNumber())
                .status(bus.getStatus())
                .toStop(bus.getToStop())
                .fromStop(bus.getFromStop())
                .bus_Route(bus.getBusRouteManager())
                .build();
    }

    public BusDto toBusDto(Bus bus) {
        if (bus == null) {
            return null;
        }

        return BusDto.builder()
                .id(bus.getId())
                .busNumber(bus.getBusNumber())
                .status(bus.getStatus())
                .toStop(bus.getToStop())
                .fromStop(bus.getFromStop())
                .bus_Route(bus.getBusRouteManager())
                .build();
    }
}