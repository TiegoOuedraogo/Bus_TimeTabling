package com.example.bus_timetabling.service.Implementation;

import com.example.bus_timetabling.dto.RouteDto;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.entities.RouteStopSchedule;;
import com.example.bus_timetabling.exception.RouteNotFoundException;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.RouteRepository;
import com.example.bus_timetabling.repository.RouteStopScheduleRepository;
import com.example.bus_timetabling.repository.StopRepository;
import com.example.bus_timetabling.service.RouteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.example.bus_timetabling.mapper.RouteMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImplementation implements RouteService {
    private final RouteStopScheduleRepository routeStopScheduleRepository;
    private final RouteRepository routeRepository;
  private final  StopRepository stopRepository;
    BusRepository busRepository;
    RouteMapper routeMapper;
   ;

    public RouteServiceImplementation(RouteStopScheduleRepository routerouteStopScheduleRepository, RouteRepository routeRepository, StopRepository stopRepository, BusRepository busRepository, RouteMapper routeMapper, RouteStopScheduleRepository routeStopScheduleRepository) {
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
        this.busRepository = busRepository;
        this.routeMapper = routeMapper;
        this.routeStopScheduleRepository = routeStopScheduleRepository;
    }

    @Override
    public void createRoute(RouteDto routeDto) {
       Route route = new Route(); //id generated automatically so no need to set it here
       route.setRouteName(routeDto.getRouteName());
       route.setDistance(routeDto.getDistance());

       //Find route schedule by id
       RouteStopSchedule routeStopSchedule = (RouteStopSchedule) routeStopScheduleRepository.findById(routeDto.getRouteStopScheduleId())
               .orElseThrow(() -> new EntityNotFoundException("RouteStopSchedule not found"));

       //Create  a list and add found RouteStopSchedule to it
        List <RouteStopSchedule> routeStopSchedules = new ArrayList<>();
        routeStopSchedules.add(routeStopSchedule);

        //Set the list of RouteStopScheudle to the Route
        route.setRouteStopSchedules(routeStopSchedules);

        //Save the route object to the database
        routeRepository.save(route);
    }

    @Override
    public List<RouteDto> retrieveAllRoutes() {
        return routeRepository.findAll().stream().map(routeMapper::toRouteDto).collect(Collectors.toList());

    }

    @Override
    public RouteDto findRouteById(Long route_id) throws RouteNotFoundException {
        return routeRepository.findById(route_id).map(routeMapper::toRouteDto).orElse(null);
    }

    @Override
    public void deleteRouteById(Long route_id) throws RouteNotFoundException {
        RouteDto routeDto = findRouteById(route_id);
        Route route = routeMapper.toRoute(routeDto);
        routeRepository.delete(route);
    }
}
