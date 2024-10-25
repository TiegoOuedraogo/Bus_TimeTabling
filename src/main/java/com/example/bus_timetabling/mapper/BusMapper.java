//package com.example.bus_timetabling.mapper;
//
//import com.example.bus_timetabling.dto.BusDto;
//import com.example.bus_timetabling.dto.BusResponseDto;
//import com.example.bus_timetabling.dto.BusRequestDto;
//import com.example.bus_timetabling.entities.Bus;
//import com.example.bus_timetabling.entities.BusRouteManager;
//import org.springframework.stereotype.Component;
//
//import java.util.stream.Collectors;
//
//@Component
//public class BusMapper {
//
//    private final TimesTableMapper timesTableMapper;
//    private final StopMapper stopMapper;
//    private final BusRouteManagerMapper BRMMapper;
//
//    public BusMapper(RouteMapper routeMapper, TimesTableMapper timesTableMapper, StopMapper stopMapper, BusRouteManagerMapper brmMapper) {
//        this.timesTableMapper = timesTableMapper;
//        this.stopMapper = stopMapper;
//        BRMMapper = brmMapper;
//    }
//
//    public Bus toBus(BusDto dto) {
//        if(dto == null) {
//            return null;
//        }
//
//        Bus bus = new Bus();
//        bus.setId(dto.getId());
//        bus.setBusNumber(dto.getBusNumber());
//        bus.setStatus(dto.getStatus());
//        bus.setFromStop(stopMapper.toStop(dto.getFromStop()));
//        bus.setToStop(stopMapper.toStop(dto.getToStop()));
//        bus.setBusRouteManager(BRMMapper.toBRM(dto.getBus_Route()));
//        return bus;
//    }
//
//    public BusDto toBusDto(Bus bus) {
//        if (bus == null) {
//            return null;
//        }
//
//        return BusDto.builder()
//                .id(bus.getId())
//                .busNumber(bus.getBusNumber())
//                .status(bus.getStatus())
//                .toStop(stopMapper.toStopDto(bus.getToStop()))
//                .fromStop(stopMapper.toStopDto(bus.getFromStop()))
//                .bus_Route(BRMMapper.toDto(bus.getBusRouteManager()))
//                .build();
//    }
//}
