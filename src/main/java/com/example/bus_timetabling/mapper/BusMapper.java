package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.dto.BusRequestDto;
import com.example.bus_timetabling.entities.Bus;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BusMapper {

    private final RouteMapper routeMapper;
    private final TimesTableMapper timesTableMapper;

    public BusMapper(RouteMapper routeMapper, TimesTableMapper timesTableMapper) {
        this.routeMapper = routeMapper;
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
        bus.setFromStopId(dto.getFromStopId());
        bus.setToStopId(dto.getToStopId());
        bus.setRoute_schedule_id(dto.getRoute_schedule_id());
        return bus;
    }

    public Bus toBus(BusRequestDto dto) {
        if(dto == null) {
            return null;
        }

        Bus bus = new Bus();
        bus.setBusNumber(dto.getBusNumber());
        bus.setStatus(dto.getStatus());
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
                .toStopId(bus.getToStopId())
                .fromStopId(bus.getFromStopId())
                .route_schedule_Id(bus.getRoute_schedule_id())
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
                .toStopId(bus.getToStopId())
                .fromStopId(bus.getFromStopId())
                .route_schedule_id(bus.getRoute_schedule_id())
                .build();
    }
}