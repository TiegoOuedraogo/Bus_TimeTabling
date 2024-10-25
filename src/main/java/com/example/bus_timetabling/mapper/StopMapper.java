//package com.example.bus_timetabling.mapper;
//
//import com.example.bus_timetabling.dto.*;
//import com.example.bus_timetabling.entities.Bus;
//import com.example.bus_timetabling.entities.Stop;
//import org.springframework.stereotype.Component;
//
//import java.util.stream.Collectors;
//
//@Component
//public class StopMapper {
//
//    private final TimesTableMapper timesTableMapper;
//    private final RouteStopScheduleMapper RSMapper;
//
//    public StopMapper(TimesTableMapper timesTableMapper, RouteStopScheduleMapper rsMapper, BusRouteManagerMapper brmMapper) {
//        this.timesTableMapper = timesTableMapper;
//        RSMapper = rsMapper;
//    }
//
//    public Stop toStop(StopDto dto) {
//        if(dto == null) {
//            return null;
//        }
//
//        Stop stop = new Stop();
//        stop.setId(dto.getId());
//        stop.setStopName(dto.getStopName());
//        stop.setRouteStopSchedule(RSMapper.toRS(dto.getRouteStopSchedule()));
////        stop.setArrivalTimesTables(dto.getArrivalTimesTable().stream().map(timesTableMapper::FromDTOtoTimesTable).collect(Collectors.toList()));
////        stop.setDepartureTimesTables(dto.getDepartureTimesTable().stream().map(timesTableMapper::FromDTOtoTimesTable).collect(Collectors.toList()));
//        return stop;
//    }
//
//    public StopDto toStopDto(Stop stop) {
//        if(stop == null) {
//            return null;
//        }
//
//        StopDto dto = new StopDto();
//        dto.setId(stop.getId());
//        dto.setStopName(stop.getStopName());
//        dto.setRouteStopSchedule(RSMapper.toRSDto(stop.getRouteStopSchedule()));
//        return dto;
//    }
//}
