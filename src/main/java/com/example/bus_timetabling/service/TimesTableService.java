package com.example.bus_timetabling.service;

import com.example.bus_timetabling.entities.TimesTable;
import com.example.bus_timetabling.repository.TimesTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TimesTableService {
    private final TimesTableRepository timesTableRepository;

    public TimesTableService(TimesTableRepository timesTableRepository) {
        this.timesTableRepository = timesTableRepository;
    }

    public List<TimesTable> getAllTimesTables() {
        return timesTableRepository.findAll();
    }

    public TimesTable getTimesTableById(Long id) {
        return timesTableRepository.findById(id).orElse(null);
    }


    public TimesTable createTimesTable(TimesTable timesTable) {
        return timesTableRepository.save(timesTable);
    }

    public void deleteTimesTable(Long id) {
        timesTableRepository.deleteById(id);
    }

    public List<TimesTable> getTimesTablesByBusId(Long busId) {
        return timesTableRepository.findByBusId(busId);
    }

    public List<TimesTable> getTimesTablesByStopId(Long stopId) {
        return timesTableRepository.findByStopId(stopId);
    }

    public TimesTable updateTimesTable(TimesTable timesTable) {
        return timesTableRepository.save(timesTable);
    }
}

