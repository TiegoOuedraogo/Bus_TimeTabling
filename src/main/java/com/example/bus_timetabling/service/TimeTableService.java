package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.TimesTableResponseDto;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface TimeTableService {

    List<TimesTableResponseDto> getAllTimesTables();

    TimesTableResponseDto getTimesTableById(Long id);

    TimesTableResponseDto createTimesTable(TimesTableResponseDto requestDto);

    TimesTableResponseDto updateTimesTable(Long id, TimesTableResponseDto requestDto);
}
