//package com.example.bus_timetabling.service.Implementation;
//
//import com.example.bus_timetabling.dto.RouteDto;
//import com.example.bus_timetabling.dto.RouteResponseDto;
//import com.example.bus_timetabling.entities.Route;
//import com.example.bus_timetabling.entities.RouteStopSchedule;;
//import com.example.bus_timetabling.exception.RouteNotFoundException;
//import com.example.bus_timetabling.repository.BusRepository;
//import com.example.bus_timetabling.repository.RouteRepository;
//import com.example.bus_timetabling.repository.RouteStopScheduleRepository;
//import com.example.bus_timetabling.repository.StopRepository;
//import com.example.bus_timetabling.service.RouteService;
//import jakarta.persistence.EntityNotFoundException;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Service;
//import com.example.bus_timetabling.mapper.RouteMapper;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
////@ServiceStatus
//@Transactional
//@Service
//public class RouteServiceImplementation implements RouteService {
//    private final RouteStopScheduleRepository routeStopScheduleRepository;
//    private final RouteRepository routeRepository;
//    private final  StopRepository stopRepository;
//    private final BusRepository busRepository;
//    private final RouteMapper routeMapper;
//   ;
//
//    public RouteServiceImplementation(RouteStopScheduleRepository routerouteStopScheduleRepository, RouteRepository routeRepository, StopRepository stopRepository, BusRepository busRepository, RouteMapper routeMapper, RouteStopScheduleRepository routeStopScheduleRepository) {
//        this.routeRepository = routeRepository;
//        this.stopRepository = stopRepository;
//        this.busRepository = busRepository;
//        this.routeMapper = routeMapper;
//        this.routeStopScheduleRepository = routeStopScheduleRepository;
//    }
//
//    @Override
//    public void createRoute(RouteDto routeDto) {
//       Route route = new Route(); //id generated automatically so no need to set it here
//       route.setRouteName(routeDto.getRouteName());
//       route.setDistance(routeDto.getDistance());
//
//       //Find route schedule by id
//       RouteStopSchedule routeStopSchedule = (RouteStopSchedule) routeStopScheduleRepository.findById(routeDto.getRouteStopScheduleId())
//               .orElseThrow(() -> new EntityNotFoundException("RouteStopSchedule not found"));
//
//        //Set the RouteStopSchedule of Route
//        route.setRouteStopSchedule(routeStopSchedule);
//
//        //Save the route object to the database
//        routeRepository.save(route);
//    }
//
//    @Override
//    public List<RouteResponseDto> retrieveAllRoutes() {
//        return routeRepository.findAll().stream().map(routeMapper::toDTO).collect(Collectors.toList());
//    }
//    @Override
//    public RouteResponseDto findRouteById(Long route_id) throws RouteNotFoundException {
//        return routeRepository.findById(route_id).map(routeMapper::toDTO).orElse(null);
//    }
//    @Override
//    public void deleteRouteById(Long route_id) throws RouteNotFoundException {
//        routeRepository.deleteById(route_id);
//    }
//}
