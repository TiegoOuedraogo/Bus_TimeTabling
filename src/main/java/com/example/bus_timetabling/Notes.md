package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.entities.TimesTable;
import com.example.bus_timetabling.repository.TimesTableRepository;
import com.example.bus_timetabling.service.TimeTableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class TimesTableServiceImpl implements TimeTableService {

    private final TimesTableRepository timesTableRepository;


    public TimesTableServiceImpl(TimesTableRepository timesTableRepository) {
        this.timesTableRepository = timesTableRepository;

    }
    @Override
    public List<TimesTableResponseDto> getAllTimesTables() {
        return timesTableRepository.findAll().stream()
               .map(this::mapTimesTableResponseDto)
               .collect(Collectors.toList());
    }

    @Override
    public TimesTableResponseDto getTimesTableById(Long id) {
        TimesTable timesTable = timesTableRepository.findById(id).orElseThrow(() -> new RuntimeException("Times Table not found"));
        return mapTimesTableResponseDto(timesTable);
    }


    @Override
    public TimesTableResponseDto createTimesTable(TimesTableResponseDto requestDto) {
        TimesTable timesTable = new TimesTable();
        timesTable.setDeparture(requestDto.getDeparture());
        timesTable.setArrival(requestDto.getArrival());
        timesTableRepository.save(timesTable);
        return mapTimesTableResponseDto(timesTable);
}

    @Override
    public TimesTableResponseDto updateTimesTable(Long id, TimesTableResponseDto requestDto) {
        TimesTable timesTable = timesTableRepository.findById(id).orElseThrow(() -> new RuntimeException("Times Table not found"));
        timesTable.setDeparture(requestDto.getDeparture());
        timesTable.setArrival(requestDto.getArrival());
        timesTableRepository.save(timesTable);
        return mapTimesTableResponseDto(timesTable);
    }


    private TimesTableResponseDto mapTimesTableResponseDto(TimesTable timesTable) {
        return TimesTableResponseDto.builder()
               .id(timesTable.getId())
                .departure(timesTable.getDeparture())
                .arrival(timesTable.getArrival())
               .build();
    }
}

package com.example.bus_timetabling.service.serviceImpl;

import com.example.bus_timetabling.dto.RouteStopScheduleResponseDto;
import com.example.bus_timetabling.entities.RouteStopSchedule;
import com.example.bus_timetabling.service.RouteStopScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteStopScheduleServiceImpl implements RouteStopScheduleService {

    private RouteStopScheduleService routeStopScheduleService;

    @Override
    public List<RouteStopScheduleResponseDto> getAllRouteStopSchedules() {
        return routeStopScheduleService.getAllRouteStopSchedules();
    }

    @Override
    public RouteStopSchedule findRouteStopScheduleById(Long id) {
        return routeStopScheduleService.findRouteStopScheduleById(id);
    }

    @Override
    public RouteStopScheduleResponseDto getRouteStopScheduleById(Long id) {
        return mapRouteStopScheduleResponse(routeStopScheduleService.findRouteStopScheduleById(id));
    }


    private RouteStopScheduleResponseDto mapRouteStopScheduleResponse(RouteStopSchedule routeStopSche){
        return RouteStopScheduleResponseDto.builder()
               .id(routeStopSche.getId())
               .stopNum(routeStopSche.getStopNum())
               .build();
    }

}

package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.RouteStopScheduleResponseDto;
import com.example.bus_timetabling.service.serviceImpl.RouteStopScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/route-stop-schedules")
public class RouteStopScheduleController {
@Autowired
private RouteStopScheduleServiceImpl routeStopScheduleService;

    public RouteStopScheduleController(RouteStopScheduleServiceImpl routeStopScheduleService) {
        this.routeStopScheduleService = routeStopScheduleService;
    }

    @GetMapping
    public List<RouteStopScheduleResponseDto> getAllRouteStopSchedules() {
        return routeStopScheduleService.getAllRouteStopSchedules();
    }

//    @PostMapping
//    public RouteStopScheduleResponseDto addRouteStopSchedule(@RequestBody RouteStopScheduleResponseDto routeStopScheduleResponseDto) {
//        return routeStopScheduleService.addRouteStopSchedule(routeStopScheduleResponseDto);
//    }
@GetMapping("/{id}")
public RouteStopScheduleResponseDto getRouteStopScheduleById(@PathVariable Long id) {
return routeStopScheduleService.getRouteStopScheduleById(id);
}
//    @PutMapping("/{id}")
//    public RouteStopScheduleResponseDto updateRouteStopSchedule(@PathVariable Long id, @RequestBody RouteStopScheduleResponseDto routeStopScheduleResponseDto) {
//        return routeStopScheduleService.updateRouteStopSchedule(id, routeStopScheduleResponseDto);
//    }
//    @DeleteMapping("/{id}")
//    public void deleteRouteStopSchedule(@PathVariable Long id) {
//        routeStopScheduleService.deleteRouteStopSchedule(id);
//    }

}

package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.service.serviceImpl.TimesTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/timetables")
public class TimesTableController {

    @Autowired
    private TimesTableServiceImpl timesTableService;

    public TimesTableController(TimesTableServiceImpl timesTableService) {
        this.timesTableService = timesTableService;
    }

    @PostMapping
    public TimesTableResponseDto createTimesTable(@RequestBody TimesTableResponseDto requestDto) {
        return timesTableService.createTimesTable(requestDto);
    }

    @PutMapping("/{id}")
    public TimesTableResponseDto updateTimesTable(
            @PathVariable Long id, @RequestBody TimesTableResponseDto requestDto) {
        return timesTableService.updateTimesTable(id, requestDto);
    }

    @GetMapping
    public List<TimesTableResponseDto> getAllTimesTables() {
        return timesTableService.getAllTimesTables();
    }

    @GetMapping("/{id}")
    public TimesTableResponseDto getTimesTableById(@PathVariable Long id) {
        return timesTableService.getTimesTableById(id);
    }

//    @DeleteMapping("/{id}")
//    public void deleteTimesTable(@PathVariable Long id) {
//        timesTableService.deleteTimesTable(id);
//    }

//    @GetMapping("/bus/{busId}")
//    public List<TimesTableResponseDto> getTimesTablesByBusId(@PathVariable Long busId) {
//        return timesTableService.getTimesTablesByBusId(busId);
//    }
//
//    @GetMapping("/stop/{stopId}")
//    public List<TimesTableResponseDto> getTimesTablesByStopId(@PathVariable Long stopId) {
//        return timesTableService.getTimesTablesByStopId(stopId);
//    }
}


//    @Override
//    public Duration calculateTravelTime(Long stopX, Long stopY) {
//        List<TimesTable> Schedules = timesTableRepository.timesbetween2Stops(stopRepository.findById(stopX).orElse(null), stopRepository.findById(stopY).orElse(null));
//              .orElseThrow(() -> new GlobalExceptionHandler());
//     TimesTable endSchedule = timesTableRepository.findTimesTableByToStop(stopRepository.findById(stopY).orElse(null));
//               .orElseThrow(() -> new GlobalExceptionHandler());
//        return Duration.between(Schedules.get(0).getDeparture(), Schedules.get(0).getArrival());
//        }