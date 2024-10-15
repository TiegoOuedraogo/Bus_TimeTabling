package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.*;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.entities.TimesTable;
import com.example.bus_timetabling.enums.Service;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.StopRepository;

import java.util.List;

public class RouteMapper {
    private final BusRepository busRepository;
    private final StopRepository stopRepository;

    public RouteMapper(BusRepository busRepository , StopRepository stopRepository){
        this.busRepository = busRepository;
        this.stopRepository = stopRepository;
    }

    // DTO to Entity
    public Route toEntity(RouteRequestDto routeRequestDto){

        //Fetch List of buses and stops
        List<Bus> buses = busRepository.retrieveAllBuses();
        List <Stop> stops = stopRepository.retrieveAllStops();

       //Create and return Route Entity
        return new Route(
              .route_id(),
               routeRequestDto.route_name()
                .origin(),
                .destination(), //update to use request dto
              .distance(),
              stops, //convert lists dto to list entity using stop mapper
              buses //convert lists dto to list entity using bus mapper
        );
    }

    // Entity to DTO
    public static RouteResponseDto toDTO(Route route){
        return new RouteResponseDto(
                route.getId(),
                route.getRouteName(),
                route.getRouteOrigin(),
                route.getDestination(),
                route.getDistance(),
                route.getStops(), //convert lists entity to list dto using stop mapper
                toDto(route.getBuses()) //convert lists entity to list dto using bus mapper
        );
    }

  /*  public static StopDto toDTO (Stop stop){
        return new StopDto(
                stop.getId(),
                stop.getStopName(),
                stop.getRoute(),
                stop.getTimesTables()

        )
    }*/

    //From Entity to DTO
    public static BusResponseDto toDto(Bus bus){
        return new BusResponseDto(
               bus.getBusNumber(),
                bus.getStatus()
        );
    }

    public static List<BusResponseDto> toDto(List<Bus> buses){
        return buses.stream()
                .map(bus -> new BusResponseDto(
                        bus.getBusNumber(),
                        bus.getStatus()
                )).toList();
    }

    //From DTO to Entity
    public static Bus toEntity(BusDto busDto){
        var bus = new Bus();
        bus.setBusNumber(busDto.busNumber());
        bus.setCapacity(busDto.capacity());
        return bus;
    }

//
}
