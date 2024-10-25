package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.BusRouteManagerDto;
import com.example.bus_timetabling.dto.BusRouteManagerResponseDto;
import com.example.bus_timetabling.entities.BusRouteManager;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BusRouteManagerMapper {

    private final BusMapper busMapper;
    private final RouteMapper routeMapper;


    public BusRouteManagerMapper(BusMapper busMapper, RouteMapper routeMapper) {
        this.busMapper = busMapper;
        this.routeMapper = routeMapper;
    }

    public BusRouteManager toBRM(BusRouteManagerDto dto) {
        if(dto == null) {
            return null;
        }

        BusRouteManager brm = new BusRouteManager();
        brm.setId(dto.getId());
        brm.setBuses(dto.getBus().stream().map(busMapper::toBus).collect(Collectors.toList()));
        brm.setRoutes(dto.getRoutes().stream().map(routeMapper::fromDtotoRoute).collect(Collectors.toList()));
        return brm;
    }

    public BusRouteManagerDto toDto(BusRouteManager brm) {
        BusRouteManagerDto dto = new BusRouteManagerDto();
        dto.setId(brm.getId());
        dto.setBus(brm.getBuses().stream().map(busMapper::toBusDto).collect(Collectors.toList()));
        dto.setRoutes(brm.getRoutes().stream().map(routeMapper::toDTO).collect(Collectors.toList()));
        return dto;
    }

    public BusRouteManager fromResponseToEntity(BusRouteManagerResponseDto dto) {
        if(dto == null) {
            return null;
        }

        BusRouteManager brm = new BusRouteManager();
        brm.setId(dto.getId());
        brm.setBuses(dto.getBus_id().stream().map(busMapper::toBus).collect(Collectors.toList()));
        brm.setRoutes(dto.getRoute_id().stream().map(routeMapper::fromDtotoRoute).collect(Collectors.toList()));
        return brm;
    }

    public BusRouteManagerResponseDto fromEntityToResponse(BusRouteManager brm) {
        BusRouteManagerResponseDto dto = new BusRouteManagerResponseDto();

        dto.setId(brm.getId());
        dto.setBus_id(brm.getBuses().stream().map(busMapper::toBusDto).collect(Collectors.toList()));
        dto.setRoute_id(brm.getRoutes().stream().map(routeMapper::toDTO).collect(Collectors.toList()));
        return dto;
    }
}
