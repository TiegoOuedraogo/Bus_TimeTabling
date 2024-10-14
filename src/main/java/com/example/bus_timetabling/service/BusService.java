package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    private final BusRepository busRepo;

//    private final Bus bus;

    public BusService(BusRepository busRepo) {
        this.busRepo = busRepo;
    }

//    public BusDto findBusById(Integer id) {
//        return busRepo.findById(id).map();
//    }
}
