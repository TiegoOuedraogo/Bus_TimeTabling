package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.TimesTableDto;
import com.example.bus_timetabling.dto.TimesTableRequestDto;
import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.entities.TimesTable;
import org.springframework.stereotype.Component;

@Component
public class TimesTableMapper {

    private final BusMapper busMapper;
    private final StopMapper stopMapper;

    public TimesTableMapper(BusMapper busMapper, StopMapper stopMapper) {
        this.busMapper = busMapper;
        this.stopMapper = stopMapper;
    }

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
        timesTable.setFromStop(stopMapper.toStop(dto.getFromStop()));
        timesTable.setToStop(stopMapper.toStop(dto.getToStop()));
        timesTable.setDeparture(dto.getDeparture());
        timesTable.setArrival(dto.getArrival());
        timesTable.setBus(busMapper.toBus(dto.getBus()));
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
                .fromStop(stopMapper.toStopDto(entity.getFromStop()))
                .toStop(stopMapper.toStopDto(entity.getToStop()))
                .departure(entity.getDeparture())
                .arrival(entity.getArrival())
                .bus(busMapper.toBusDto(entity.getBus()))
                .build();
    }

    public TimesTableResponseDto toTimesTableResponseDto(TimesTable entity) {
        if (entity == null) {
            return null;
        }

        return TimesTableResponseDto.builder()
                .fromStop(stopMapper.toStopDto(entity.getFromStop()))
                .toStop(stopMapper.toStopDto(entity.getToStop()))
                .departure(entity.getDeparture())
                .arrival(entity.getArrival())
                .bus(busMapper.toBusDto(entity.getBus()))
                .build();
    }
}