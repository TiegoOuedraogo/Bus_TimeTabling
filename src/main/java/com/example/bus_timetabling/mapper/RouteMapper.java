package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.*;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.entities.Stop;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RouteMapper {
    private final BusMapper busMapper;
    private final StopMapper stopMapper;

    public RouteMapper(BusMapper busMapper, StopMapper stopMapper) {
        this.busMapper = busMapper;
        this.stopMapper = stopMapper;
    }


    public Route toRoute(RouteDto dto) {
        if (dto == null) {
            return null;
        }

        Route route = new Route();

        route.setId(dto.getId());
        route.setRouteName(dto.getRouteName());
        route.setRouteOrigin(dto.getOrigin());
        route.setDestination(dto.getDestination());
        route.setDistance(dto.getDistance());

        //Convert list of Stops dtos to Stop entity
        List<Stop> stops = dto.getStops() !=null
                ? dto.getStops().stream()
                .map(stopMapper::toStop)
                .collect(Collectors.toList())
                : null;
       route.setStops(stops);

        //Convert list of Buses dtos to Bus Entity
        List<Bus> buses = dto.getBuses() !=null
                ? dto.getBuses().stream()
                .map(busMapper::toBus)
                .collect(Collectors.toList())
                : null;

        route.setBuses(buses); //convert from list of DTOs to route
        return route;
    }

    public RouteDto toRouteDto(Route route) {
        RouteDto dto = new RouteDto();
        dto.setId(route.getId());
        dto.setRouteName(route.getRouteName());
        dto.setDestination(route.getDestination());
        dto.setDistance(route.getDistance());
        dto.setOrigin(route.getRouteOrigin());
        dto.setBuses(route.getBuses().stream().map(busMapper::toBusDto).collect(Collectors.toList()));
        dto.setStops(route.getStops().stream().map(stopMapper::toStopDto).collect(Collectors.toList()));
        return dto;
    }
//    public Route toRoute(RouteRequestDto routeRequestDto) {
//        Route dto = new Route();
//        dto.setId(routeRequestDto.getId());
//        dto.setRouteName(routeRequestDto.getRouteName());
//        dto.setDestination(routeRequestDto.getDestination());
//        dto.setDistance(routeRequestDto.getDistance());
//        dto.setRouteOrigin(routeRequestDto.getRouteOrigin());
//        dto.setBuses(routeRequestDto.getBuses().stream().map(busMapper::toBus).collect(Collectors.toList()));
//        dto.setStops(routeRequestDto.getStops().stream().map(stopMapper::toStop).collect(Collectors.toList()));
//        return dto;
//    }


    //    public RouteResponseDto RouteDtoToRouteResponseDto(RouteDto routeDto){
//        RouteResponseDto dto = new RouteResponseDto();
//        dto.setId(routeDto.getId());
//        dto.setRouteName(routeDto.getRouteName());
//        dto.setRouteOrigin(routeDto.getOrigin());
//        dto.setStops(routeDto.getStops());
//        dto.setDistance(routeDto.getDistance());
//        dto.setDestination(routeDto.getDestination());
//        dto.setBuses(routeDto.getBuses().stream().map(busMapper::toBusResponseDto).collect(Collectors.toList()));
//        return dto;
//    }


//    public RouteResponseDto toRouteResponseDto(Route route) {
//        if (route == null) {
//            return null;
//        }
//       //Convert list of Stops from route to DTOs
//        List<StopResponseDto> stopResponseDtos = route.getStops() !=null
//                ? route.getStops().stream()
//                .map(stopMapper::toStopResponseDto)
//                .collect(Collectors.toList())
//                : null;
//        //Convert list of Buses route to dtos
//        List<BusResponseDto> busResponseDtos = route.getBuses() !=null
//                ? route.getBuses().stream()
//                .map(busMapper::toBusResponseDto)
//                .collect(Collectors.toList())
//                : null;
//
//        return new RouteResponseDto(
//                route.getId(),
//                route.getRouteName(),
//                route.getRouteOrigin(),
//                route.getDestination(),
//                route.getDistance(),
//                stopResponseDtos,
//                busResponseDtos
//        );
//    }

}