package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.*;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Stop;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StopMapper {

    private final TimesTableMapper timesTableMapper;
    private final RouteStopScheduleMapper RSMapper;

    public StopMapper(TimesTableMapper timesTableMapper, RouteStopScheduleMapper rsMapper, BusRouteManagerMapper brmMapper) {
        this.timesTableMapper = timesTableMapper;
        RSMapper = rsMapper;
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
        stop.setRouteStopSchedule(RSMapper.toRS(dto.getRouteStopSchedule()));
//        stop.setArrivalTimesTables(dto.getArrivalTimesTable().stream().map(timesTableMapper::FromDTOtoTimesTable).collect(Collectors.toList()));
//        stop.setDepartureTimesTables(dto.getDepartureTimesTable().stream().map(timesTableMapper::FromDTOtoTimesTable).collect(Collectors.toList()));
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

    public StopDto toStopDto(Stop stop) {
        if(stop == null) {
            return null;
        }

        StopDto dto = new StopDto();
        dto.setId(stop.getId());
        dto.setStopName(stop.getStopName());
        dto.setRouteStopSchedule(RSMapper.toRSDto(stop.getRouteStopSchedule()));
        return dto;
    }

//    public StopResponseDto toStopResponseDto(Stop stop) {
//        if (stop == null) {
//            return null;
//        }
//
//        return StopResponseDto.builder()
//                .id(stop.getId())
//                .stopName(stop.getStopName())
//                .routeStopSchedule(stop.getRouteStopSchedule())
//                .arrivalTimesTable(stop.getArrivalTimesTables().stream().map(timesTableMapper::toTimesTableDto).collect(Collectors.toList()))
//                .departureTimesTable(stop.getDepartureTimesTables().stream().map(timesTableMapper::toTimesTableDto).collect(Collectors.toList()))
//                .build();
//    }



    public Stop fromResponseToEntity(StopResponseDto dto) {
        if(dto == null) {
            return null;
        }

        Stop stop = new Stop();
        stop.setId(dto.getId());
        stop.setStopName(dto.getStopName());
        stop.setRouteStopSchedule(RSMapper.toRS(dto.getRouteStopSchedule()));
        return stop;
    }

    public StopResponseDto fromEntityToResponse(Stop stop) {
        StopResponseDto dto = new StopResponseDto();
        dto.setId(stop.getId());
        dto.setStopName(stop.getStopName());
        dto.setRouteStopSchedule(RSMapper.toRSDto(stop.getRouteStopSchedule()));
        return dto;
    }
}
