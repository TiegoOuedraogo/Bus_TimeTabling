package com.example.bus_timetabling.mapper;

import com.example.bus_timetabling.dto.BusDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.entities.Bus;
import org.springframework.stereotype.Service;

@Service
public class BusMapper {

    public Bus toBus(BusDto dto) {
        if(dto == null) {
            throw new NullPointerException("The Bus DTO is null");
        }

        var bus = new Bus();
        bus.setBusNumber(dto.busNumber());
        bus.setCapacity(dto.capacity());

        return bus;
    }

    public BusResponseDto toBusResponseDTO(Bus bus) {
        return new BusResponseDto(bus.getBusNumber(), bus.getStatus());
    }
}
