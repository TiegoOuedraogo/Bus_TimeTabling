package com.example.bus_timetabling.service.Implementation;
import com.example.bus_timetabling.dto.RouteStopScheduleDto;
import com.example.bus_timetabling.entities.RouteStopSchedule;
import com.example.bus_timetabling.exception.RouteStopScheduleNotFoundException;
import com.example.bus_timetabling.repository.RouteStopScheduleRepository;
import com.example.bus_timetabling.service.RouteStopScheduleService;

import java.util.List;

public class RouteStopScheduleServiceImplementation implements RouteStopScheduleService {
    private final RouteStopScheduleRepository routeStopScheduleRepository;

    public RouteStopScheduleServiceImplementation(RouteStopScheduleRepository routeStopScheduleRepository) {
        this.routeStopScheduleRepository = routeStopScheduleRepository;
    }

    @Override
    public void createRouteStopSchedule(RouteStopScheduleDto routeStopScheduleDto) {
       RouteStopSchedule routeStopSchedule = new RouteStopSchedule(); //id generated automatically so no need to set
        routeStopSchedule.setStopNum(routeStopScheduleDto.getStopNum());
        routeStopSchedule.setRoutes(routeStopScheduleDto.getRoute());
        routeStopSchedule.setStops(routeStopScheduleDto.getStop());

        //Save RouteStopSchedule object to database
        routeStopScheduleRepository.save(routeStopSchedule);

    }

    @Override
    public List<RouteStopScheduleDto> retrieveAllRouteStopSchedules() {
        return List.of();
    }

    @Override
    public RouteStopScheduleDto findRouteScheduleById(Long route_stop_id) throws RouteStopScheduleNotFoundException {
        return null;
    }

    @Override
    public void deleteRouteById(Long route_stop_id) throws RouteStopScheduleNotFoundException {

    }
}

