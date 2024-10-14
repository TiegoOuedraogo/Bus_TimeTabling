package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.Route;
import com.example.bus_timetabling.entities.TimesTable;

import java.util.List;

public record StopResponseDto(String stopName, Route routes, List<TimesTable> timesTables) {
}
