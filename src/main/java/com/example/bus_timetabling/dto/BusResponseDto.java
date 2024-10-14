package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.enums.Service;

public record BusResponseDto(String busNumber, Service status) {
}
