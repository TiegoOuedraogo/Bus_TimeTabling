package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.StopDto;
import com.example.bus_timetabling.dto.StopResponseDto;
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
        stop.setRoute(routeMapper.toRoute(stopDto.getRoute()));

        //??
        if (stopDto.getTimesTables() != null) {
            stop.setTimesTables(stopDto.getTimesTables().stream()
                    .map(timesTableMapper::toTimesTable)
                    .collect(Collectors.toList()));
        }
        return stop;
    }

    public StopResponseDto toStopResponseDto(Stop stop) {
        if (stop == null) {
            return null;
        }
        //??
        List<TimesTableDto> timesTableDtos = stop.getTimesTables() != null
                ? stop.getTimesTables().stream()
                .map(timesTableMapper::toTimesTableDto)
                .collect(Collectors.toList())
                : null;

        return new StopResponseDto(
                stop.getId(),
                stop.getStopName(),
                routeMapper.toRouteDto(stop.getRoute()),
                timesTableDtos
        );
    }


}
