package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.entities.TimesTable;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service

public interface TimeTableService {

    List<TimesTableResponseDto> getAllTimesTables();

    TimesTableResponseDto getTimesTableById(Long id);

    TimesTableResponseDto createTimesTable(TimesTableResponseDto requestDto);

    TimesTableResponseDto updateTimesTable(Long id, TimesTableResponseDto requestDto);


    List<TimesTableResponseDto> findNextThreeBusesAtStop(Long stopId, LocalTime currentTime);
}

