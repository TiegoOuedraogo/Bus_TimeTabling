//package com.example.bus_timetabling.mapper;
//
//import com.example.bus_timetabling.dto.BusRouteManagerDto;
//import com.example.bus_timetabling.dto.BusRouteManagerResponseDto;
//import com.example.bus_timetabling.entities.BusRouteManager;
//import org.springframework.stereotype.Component;
//
//import java.util.stream.Collectors;
//
//@Component
//public class BusRouteManagerMapper {
//
//    private final BusMapper busMapper;
//    private final RouteMapper routeMapper;
//
//
//    public BusRouteManagerMapper(BusMapper busMapper, RouteMapper routeMapper) {
//        this.busMapper = busMapper;
//        this.routeMapper = routeMapper;
//    }
//
//    public BusRouteManager toBRM(BusRouteManagerDto dto) {
//        if(dto == null) {
//            return null;
//        }
//
//        BusRouteManager brm = new BusRouteManager();
//        brm.setId(dto.getId());
//        return brm;
//    }
//
//    public BusRouteManagerDto toDto(BusRouteManager brm) {
//        BusRouteManagerDto dto = new BusRouteManagerDto();
//        dto.setId(brm.getId());
//
//        return dto;
//    }
//
//}
