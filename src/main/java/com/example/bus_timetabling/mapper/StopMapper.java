package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.*;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Stop;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StopMapper {

    private final TimesTableMapper timesTableMapper;

    public StopMapper(TimesTableMapper timesTableMapper) {

        this.timesTableMapper = timesTableMapper;
    }


    //DTO to Entity
    public Stop toEntity(StopResponseDto stopResponseDto) {

        return new Stop(
                stopResponseDto.getId(),
                stopResponseDto.getStopName(),
                stopResponseDto.getRouteStopSchedule(),

                //convert lists dto to list entity using timestable mapper
                stopResponseDto.getDepartureTimesTable().stream().map(timesTableMapper::toEntity).collect(Collectors.toList()),

                //convert lists dto to list entity
                stopResponseDto.getArrivalTimesTable().stream().map(timesTableMapper::toEntity).collect(Collectors.toList())
        );

    }

    public Stop toStop(StopDto dto) {
        if(dto == null) {
            return null;
        }

        Stop stop = new Stop();
        stop.setId(dto.getId());
        stop.setStopName(dto.getStopName());
        stop.setRouteStopSchedule(dto.getRouteStopSchedule());
        stop.setArrivalTimesTables(dto.getArrivalTimesTable().stream().map(timesTableMapper::FromDTOtoTimesTable).collect(Collectors.toList()));
        stop.setDepartureTimesTables(dto.getDepartureTimesTable().stream().map(timesTableMapper::FromDTOtoTimesTable).collect(Collectors.toList()));
        return stop;
    }

    public Stop toStop(StopRequestDto dto) {
        if(dto == null) {
            return null;
        }

        Stop stop = new Stop();
        stop.setStopName(dto.getStopName());
        return stop;
    }

    public StopResponseDto toStopResponseDto(Stop stop) {
        if (stop == null) {
            return null;
        }

        return StopResponseDto.builder()
                .id(stop.getId())
                .stopName(stop.getStopName())
                .routeStopSchedule(stop.getRouteStopSchedule())
                .arrivalTimesTable(stop.getArrivalTimesTables().stream().map(timesTableMapper::toTimesTableDto).collect(Collectors.toList()))
                .departureTimesTable(stop.getDepartureTimesTables().stream().map(timesTableMapper::toTimesTableDto).collect(Collectors.toList()))
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
