package com.example.bus_timetabling.service;

import com.example.bus_timetabling.dto.TimesTableRequestDto;
import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.entities.TimesTable;
import com.example.bus_timetabling.mapper.TimesTableMapper;
import com.example.bus_timetabling.repository.BusRepository;
import com.example.bus_timetabling.repository.StopRepository;
import com.example.bus_timetabling.repository.TimesTableRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TimesTableServiceTest {

    @Mock
    private TimesTableRepository timesTableRepository;

    @Mock
    private BusRepository busRepository;

    @Mock
    private StopRepository stopRepository;

    @Mock
    private TimesTableMapper timesTableMapper;

    @InjectMocks
    private TimesTableService timesTableService;

    private Bus validBus;
    private Stop validFromStop;
    private Stop validToStop;
    private TimesTable validTimesTable;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        validBus = new Bus();
        validBus.setId(1L);

        validFromStop = new Stop();
        validFromStop.setId(2L);

        validToStop = new Stop();
        validToStop.setId(3L);

        validTimesTable = new TimesTable();
        validTimesTable.setId(1L);
        validTimesTable.setDeparture(LocalTime.of(14, 8, 0));
        validTimesTable.setArrival(LocalTime.of(14, 10, 0));
        validTimesTable.setBus(validBus);
        validTimesTable.setFromStop(validFromStop);
        validTimesTable.setToStop(validToStop);
    }

    @Test
    void getAllTimesTables() {
        when(timesTableRepository.findAll()).thenReturn(List.of(validTimesTable));
        when(timesTableMapper.toTimesTableResponseDto(validTimesTable)).thenReturn(new TimesTableResponseDto());

        List<TimesTableResponseDto> result = timesTableService.getAllTimesTables();

        assertEquals(1, result.size());
        verify(timesTableRepository, times(1)).findAll();
    }

    @Test
    void getTimesTableById() {
        when(timesTableRepository.findById(1L)).thenReturn(Optional.of(validTimesTable));
        when(timesTableMapper.toTimesTableResponseDto(validTimesTable)).thenReturn(new TimesTableResponseDto());

        TimesTableResponseDto result = timesTableService.getTimesTableById(1L);

        assertNotNull(result);
        verify(timesTableRepository, times(1)).findById(1L);
    }

    @Test
    void getTimesTableById_NotFound() {
        when(timesTableRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> timesTableService.getTimesTableById(1L));

        verify(timesTableRepository, times(1)).findById(1L);
        verify(timesTableRepository, never()).save(any(TimesTable.class));

    }


    @Test
    void createTimesTable() {
        TimesTableRequestDto requestDto = new TimesTableRequestDto(
                LocalTime.of(14, 9, 0),
                LocalTime.of(14, 11, 0),
                1L,
                2L,
                3L
        );

        when(busRepository.findById(1L)).thenReturn(Optional.of(validBus));
        when(stopRepository.findById(2L)).thenReturn(Optional.of(validFromStop));
        when(stopRepository.findById(3L)).thenReturn(Optional.of(validToStop));

        when(timesTableMapper.toTimesTable(any(TimesTableRequestDto.class))).thenReturn(validTimesTable);
        when(timesTableMapper.toTimesTableResponseDto(any(TimesTable.class))).thenReturn(new TimesTableResponseDto());

        when(timesTableRepository.save(any(TimesTable.class))).thenReturn(validTimesTable);

        TimesTableResponseDto result = timesTableService.createTimesTable(requestDto);

        assertNotNull(result);
        verify(timesTableRepository, times(1)).save(any(TimesTable.class));
    }


    @Test
    void deleteTimesTable() {
        when(timesTableRepository.existsById(1L)).thenReturn(true);
        timesTableService.deleteTimesTable(1L);

        verify(timesTableRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteTimesTable_NotFound() {
        when(timesTableRepository.existsById(1L)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> timesTableService.deleteTimesTable(1L));

        verify(timesTableRepository, times(1)).existsById(1L);
        verify(timesTableRepository, never()).deleteById(anyLong());
    }

    @Test
    void getTimesTablesByBusId() {
        when(timesTableRepository.findByBusId(1L)).thenReturn(List.of(validTimesTable));
        when(timesTableMapper.toTimesTableResponseDto(validTimesTable)).thenReturn(new TimesTableResponseDto());

        List<TimesTableResponseDto> result = timesTableService.getTimesTablesByBusId(1L);

        assertEquals(1, result.size());
        verify(timesTableRepository, times(1)).findByBusId(1L);
    }

    @Test
    void getTimesTablesByStopId() {
        when(timesTableRepository.findAll()).thenReturn(List.of(validTimesTable));
        when(timesTableMapper.toTimesTableResponseDto(validTimesTable)).thenReturn(new TimesTableResponseDto());

        List<TimesTableResponseDto> result = timesTableService.getTimesTablesByStopId(2L);

        assertEquals(1, result.size());
        verify(timesTableRepository, times(1)).findAll();
    }

    @Test
    void updateTimesTable() {
        TimesTableRequestDto requestDto = new TimesTableRequestDto(
                LocalTime.of(14, 9, 0),
                LocalTime.of(14, 11, 0),
                1L,
                2L,
                3L
        );
        when(timesTableMapper.toTimesTable(requestDto)).thenReturn(validTimesTable);
        when(timesTableRepository.findById(1L)).thenReturn(Optional.of(validTimesTable));
        when(timesTableRepository.save(validTimesTable)).thenReturn(validTimesTable);
        when(timesTableMapper.toTimesTableResponseDto(validTimesTable)).thenReturn(new TimesTableResponseDto());
        TimesTableResponseDto result = timesTableService.updateTimesTable(1L, requestDto);
        assertNotNull(result);
        verify(timesTableRepository, times(1)).save(validTimesTable);
    }

    @Test
    void updateTimesTable_NotFoundBus() {
        TimesTableRequestDto requestDto = new TimesTableRequestDto(
                LocalTime.of(14, 9, 0),
                LocalTime.of(14, 11, 0),
                99L,
                2L,
                3L
        );

        when(busRepository.findById(99L)).thenReturn(Optional.empty()); // Bus not found

        Exception exception = assertThrows(RuntimeException.class, () ->
                timesTableService.updateTimesTable(1L, requestDto));

        assertEquals("Bus not found", exception.getMessage());
    }

    @Test
    void updateTimesTable_NotFoundToStop() {
        TimesTableRequestDto requestDto = new TimesTableRequestDto(
                LocalTime.of(14, 9, 0),
                LocalTime.of(14, 11, 0),
                1L,
                2L,
                99L
        );

        when(busRepository.findById(1L)).thenReturn(Optional.of(validBus));
        when(stopRepository.findById(2L)).thenReturn(Optional.of(validFromStop));
        when(stopRepository.findById(99L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () ->
                timesTableService.updateTimesTable(1L, requestDto));

        assertEquals("To Stop not found", exception.getMessage());
    }

@Test
    void updateTimesTable_NotFound() {
        TimesTableRequestDto requestDto;
        requestDto = new TimesTableRequestDto(
                LocalTime.of(14, 9, 0),
                LocalTime.of(14, 11, 0),
                1L,
                2L,
                3L
        );
        when(timesTableRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> timesTableService.updateTimesTable(1L, requestDto));
        verify(timesTableRepository, times(1)).findById(1L);
        verify(timesTableRepository, never()).save(any(TimesTable.class));

    }
}

