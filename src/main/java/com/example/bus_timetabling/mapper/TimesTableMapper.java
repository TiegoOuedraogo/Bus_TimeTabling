package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.TimesTableDto;
import com.example.bus_timetabling.dto.TimesTableRequestDto;
import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.entities.TimesTable;
import org.springframework.stereotype.Component;

@Component
public class TimesTableMapper {

    public TimesTable toEntity(TimesTableResponseDto timesTableResponseDto){
        return new TimesTable(
                timesTableResponseDto.getId(),
                timesTableResponseDto.getFromStop(),
                timesTableResponseDto.getToStop(),
                timesTableResponseDto.getDeparture(),
                timesTableResponseDto.getArrival(),
                timesTableResponseDto.getBus()
        );

    }

    public TimesTable FromDTOtoTimesTable(TimesTableDto dto) {
        if (dto == null) {
            return null;
        }

        TimesTable timesTable = new TimesTable();
        timesTable.setFromStop(dto.getFromStop());
        timesTable.setToStop(dto.getToStop());
        timesTable.setDeparture(dto.getDeparture());
        timesTable.setArrival(dto.getArrival());
        timesTable.setBus(dto.getBus());
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
                .fromStop(entity.getFromStop())
                .toStop(entity.getToStop())
                .departure(entity.getDeparture())
                .arrival(entity.getArrival())
                .bus(entity.getBus())
                .build();
    }

    public TimesTableResponseDto toTimesTableResponseDto(TimesTable entity) {
        if (entity == null) {
            return null;
        }

        return TimesTableResponseDto.builder()
                .fromStop(entity.getFromStop())
                .toStop(entity.getToStop())
                .departure(entity.getDeparture())
                .arrival(entity.getArrival())
                .bus(entity.getBus())
                .build();
    }
}