package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.entities.TimesTable;
import com.example.bus_timetabling.service.TimesTableService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/api/timetables")
public class TimesTableController {
    private final TimesTableService timesTableService;

    public TimesTableController(TimesTableService timesTableService) {
        this.timesTableService = timesTableService;
    }

    @GetMapping
    public List<TimesTable> getAllTimesTables() {
        return timesTableService.getAllTimesTables();
    }

    @PostMapping("/timesTable/{id}")
    public TimesTable createTimesTable(@RequestBody TimesTable timesTable) {
        return timesTableService.createTimesTable(timesTable);
    }

    @GetMapping("/timesTable/{id}")
    public TimesTable getTimesTableById(@PathVariable Long id) {
        return timesTableService.getTimesTableById(id);
    }

    @PutMapping("/timesTable/{id}")
    public TimesTable updateTimesTable(@PathVariable Long id, @RequestBody TimesTable updatedTimesTable) {
        updatedTimesTable.setId(id);
        return timesTableService.updateTimesTable(updatedTimesTable);
    }

    @DeleteMapping("/timesTable/{id}")
    public void deleteTimesTable(@PathVariable Long id) {
        timesTableService.deleteTimesTable(id);
    }

    @GetMapping("/timesTable/bus/{busId}")
    public List<TimesTable> getTimesTablesByBusId(@PathVariable Long busId) {
        return timesTableService.getTimesTablesByBusId(busId);
    }

    @GetMapping("/timesTable/stop/{stopId}")
    public List<TimesTable> getTimesTablesByStopId(@PathVariable Long stopId) {
        return timesTableService.getTimesTablesByStopId(stopId);
    }

}