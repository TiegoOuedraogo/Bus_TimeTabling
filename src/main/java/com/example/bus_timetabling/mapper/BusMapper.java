package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.dto.TimesTableDto;
import com.example.bus_timetabling.entities.Bus;
import org.springframework.stereotype.Component;

import java.util.List;
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
        bus.setCapacity(dto.getCapacity());
        bus.setStatus(dto.getStatus());
        bus.setRoute(routeMapper.toRoute(dto.getRoute()));

        if (dto.getTimesTables() != null) {
            bus.setTimesTables(dto.getTimesTables().stream()
                    .map(timesTableMapper::toTimesTable)
                    .collect(Collectors.toList()));
        }

        return bus;
    }

    public BusResponseDto toBusResponseDto(Bus bus) {
        if (bus == null) {
            return null;
        }

        List<TimesTableDto> timesTableDtos = bus.getTimesTables() != null
                ? bus.getTimesTables().stream()
                .map(timesTableMapper::toTimesTableDto)
                .collect(Collectors.toList())
                : null;

        return new BusResponseDto(
                bus.getId(),
                bus.getBusNumber(),
                bus.getCapacity(),
                bus.getStatus(),
                routeMapper.toRouteDto(bus.getRoute()),
                timesTableDtos
        );
    }
}