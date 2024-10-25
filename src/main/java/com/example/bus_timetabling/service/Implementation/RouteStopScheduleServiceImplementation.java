//package com.example.bus_timetabling.service.Implementation;
//import com.example.bus_timetabling.dto.RouteStopScheduleDto;
//import com.example.bus_timetabling.dto.RouteStopScheduleResponseDto;
//import com.example.bus_timetabling.entities.RouteStopSchedule;
//import com.example.bus_timetabling.exception.RouteStopScheduleNotFoundException;
//import com.example.bus_timetabling.mapper.RouteMapper;
//import com.example.bus_timetabling.repository.RouteStopScheduleRepository;
//import com.example.bus_timetabling.service.RouteStopScheduleService;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
////@ServiceStatus
//@Transactional
//@Service
//public class RouteStopScheduleServiceImplementation implements RouteStopScheduleService {
//    private final RouteStopScheduleRepository routeStopScheduleRepository;
//    private final RouteMapper routeMapper;
//
//    public RouteStopScheduleServiceImplementation(RouteStopScheduleRepository routeStopScheduleRepository, RouteMapper routeMapper) {
//        this.routeStopScheduleRepository = routeStopScheduleRepository;
//        this.routeMapper = routeMapper;
//    }
//
//    @Override
//    public void createRouteStopSchedule(RouteStopScheduleResponseDto routeStopScheduleResponseDto) {
//       RouteStopSchedule routeStopSchedule = new RouteStopSchedule(); //id generated automatically so no need to set
//        routeStopSchedule.setStopNum(routeStopScheduleResponseDto.getStopNum());
//        routeStopSchedule.setRoutes(routeStopScheduleResponseDto.getRoutes().stream().map(routeMapper::toEntity).collect(Collectors.toList()));
//        routeStopSchedule.setStops(routeStopScheduleResponseDto.getStops().stream().map(stopMapper::toEntity).collect(Collectors.toList()));
//
//        //Save RouteStopSchedule object to database
//        routeStopScheduleRepository.save(routeStopSchedule);
//
//    }
//
//    @Override
//    public List<RouteStopScheduleDto> retrieveAllRouteStopSchedules() {
//
//        return routeStopScheduleRepository.findAll().stream().map(routeStopScheduleMapper::toDTO).collect(Collectors.toList());
//    }
//
//    @Override
//    public RouteStopScheduleDto findRouteScheduleById(Long route_stop_id) throws RouteStopScheduleNotFoundException {
//        return routeStopScheduleRepository.findById(route_stop_id).map(routeStopSchedule::toDto).orElse(null);
//    }
//
//    @Override
//    public void deleteRouteStopScheduleById(Long route_stop_id) throws RouteStopScheduleNotFoundException {
//        routeStopScheduleRepository.deleteById(route_stop_id);
//
//    }
//}
//
