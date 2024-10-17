package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.TimesTableDto;
import com.example.bus_timetabling.dto.TimesTableRequestDto;
import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.entities.TimesTable;
import org.springframework.stereotype.Component;

@Component
public class TimesTableMapper {

    public TimesTable toTimesTable(TimesTableDto dto) {
        if (dto == null) {
            return null;
        }

        TimesTable timesTable = new TimesTable();
        timesTable.setId(dto.getId());
        timesTable.setDeparture(dto.getDeparture());
        timesTable.setArrival(dto.getArrival());
        timesTable.setSegmentDistance(dto.getSegmentDistance());
        return timesTable;
    }

    public TimesTable toTimesTable(TimesTableRequestDto dto) {
        if (dto == null) {
            return null;
        }

        TimesTable timesTable = new TimesTable();
        timesTable.setDeparture(dto.getDeparture());
        timesTable.setArrival(dto.getArrival());
//        timesTable.setSegmentDistance(dto.getSegmentDistance());
        return timesTable;
    }

    public TimesTableDto toTimesTableDto(TimesTable entity) {
        if (entity == null) {
            return null;
        }

        return TimesTableDto.builder()
                .id(entity.getId())
                .departure(entity.getDeparture())
                .arrival(entity.getArrival())
                .segmentDistance(entity.getSegmentDistance())
                .busId(entity.getBus().getId())
                .fromStopId(entity.getFromStop().getId())
                .toStopId(entity.getToStop().getId())
                .build();
    }

    public TimesTableResponseDto toTimesTableResponseDto(TimesTable entity) {
        if (entity == null) {
            return null;
        }

        return TimesTableResponseDto.builder()
                .id(entity.getId())
                .departure(entity.getDeparture())
                .arrival(entity.getArrival())
                .segmentDistance(entity.getSegmentDistance())
                .busId(entity.getBus().getId())
                .busNumber(entity.getBus().getBusNumber())
                .fromStopId(entity.getFromStop().getId())
                .fromStopName(entity.getFromStop().getStopName())
                .toStopId(entity.getToStop().getId())
                .toStopName(entity.getToStop().getStopName())
                .build();
    }
}