package com.example.bus_timetabling.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Getter
public record BusRequestDto(  String busNumber,
    List<TimesTableDto> timesTables,
    Service status){}

