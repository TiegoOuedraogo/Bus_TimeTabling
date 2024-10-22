//package com.example.bus_timetabling.mapper;
//
//import com.example.bus_timetabling.dto.TimesTableDto;
//import com.example.bus_timetabling.dto.TimesTableRequestDto;
//import com.example.bus_timetabling.dto.TimesTableResponseDto;
//import com.example.bus_timetabling.entities.TimesTable;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TimesTableMapper {
//
//    public TimesTable toTimesTable(TimesTableDto dto) {
//        if (dto == null) {
//            return null;
//        }
//
//        TimesTable timesTable = new TimesTable();
//        timesTable.setFromStopId(dto.getFromStopId());
//        timesTable.setToStopId(dto.getToStopId());
//        timesTable.setDeparture(dto.getDeparture());
//        timesTable.setArrival(dto.getArrival());
//        timesTable.setBus(dto.getBus());
//        timesTable.setRoute(dto.getRoute());
//        return timesTable;
//    }
//
//    public TimesTable toTimesTable(TimesTableRequestDto dto) {
//        if (dto == null) {
//            return null;
//        }
//
//        TimesTable timesTable = new TimesTable();
//        timesTable.setDeparture(dto.getDeparture());
//        timesTable.setArrival(dto.getArrival());
////        timesTable.setSegmentDistance(dto.getSegmentDistance());
//        return timesTable;
//    }
//
//    public TimesTableDto toTimesTableDto(TimesTable entity) {
//        if (entity == null) {
//            return null;
//        }
//
//        return TimesTableDto.builder()
//                .fromStopId(entity.getFromStopId())
//                .toStopId(entity.getToStopId())
//                .departure(entity.getDeparture())
//                .arrival(entity.getArrival())
//                .bus(entity.getBus())
//                .route(entity.getRoute())
//                .build();
//    }
//
//    public TimesTableResponseDto toTimesTableResponseDto(TimesTable entity) {
//        if (entity == null) {
//            return null;
//        }
//
//        return TimesTableResponseDto.builder()
//                .fromStopId(entity.getFromStopId())
//                .toStopId(entity.getToStopId())
//                .departure(entity.getDeparture())
//                .arrival(entity.getArrival())
//                .bus(entity.getBus())
//                .route(entity.getRoute())
//                .build();
//    }
//}