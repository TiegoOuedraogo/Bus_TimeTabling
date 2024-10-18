package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.StopDto;
import com.example.bus_timetabling.dto.TimesTableDto;
import com.example.bus_timetabling.entities.Stop;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StopMapper {
    private final RouteMapper routeMapper;
    private final TimesTableMapper timesTableMapper;


    public StopMapper(RouteMapper routeMapper, TimesTableMapper timesTableMapper) {
        this.routeMapper = routeMapper;
        this.timesTableMapper = timesTableMapper;
    }

    public Stop toStop(StopDto stopDto) {
        if(stopDto == null) {
            return null;
        }

        Stop stop = new Stop();
        stop.setId(stopDto.getId());
        stop.setStopName(stopDto.getStopName());
        stop.setOrderInRoute(stopDto.getOrderInRoute());
        stop.setRoute(routeMapper.toRoute(stopDto.getRoute()));
        //??
        if (stopDto.getDepartureTimesTables()!= null) {
            stop.setDepartureTimesTables(stopDto.getDepartureTimesTables().stream()
                    .map(timesTableMapper::toTimesTable)
                    .collect(Collectors.toList()));
        }
        if (stopDto.getArrivalTimesTables() != null) {
            stop.setArrivalTimesTables(stopDto.getArrivalTimesTables().stream()
                    .map(timesTableMapper::toTimesTable)
                    .collect(Collectors.toList()));
        }
        return stop;
    }

    public StopDto toStopDto(Stop stop) {
        if (stop == null) {
            return null;
        }
        //??
        List<TimesTableDto> departureTimesTables = stop.getDepartureTimesTables() != null
                ? stop.getDepartureTimesTables().stream()
                .map(timesTableMapper::toTimesTableDto)
                .collect(Collectors.toList())
                : null;

        List<TimesTableDto> arrivalTimesTables = stop.getArrivalTimesTables()!= null
                ? stop.getArrivalTimesTables().stream()
                .map(timesTableMapper::toTimesTableDto)
                .collect(Collectors.toList())
                : null;

        //fix this later
        return new StopDto(
                stop.getId(),
                stop.getStopName(),
                stop.getOrderInRoute(),
                routeMapper.toRouteDto(stop.getRoute()),
                departureTimesTables,
                arrivalTimesTables
        );
    }


}
