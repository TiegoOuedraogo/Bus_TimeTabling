package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.TimesTableDto;
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
        timesTable.setDepartures(dto.getDepartures());
        timesTable.setArrival(dto.getArrival());
        return timesTable;
    }

    public TimesTableDto toTimesTableDto(TimesTable entity) {
        if (entity == null) {
            return null;
        }

        TimesTableDto dto = new TimesTableDto();
        dto.setId(entity.getId());
        dto.setDepartures(entity.getDepartures());
        dto.setArrival(entity.getArrival());
        return dto;
    }
}