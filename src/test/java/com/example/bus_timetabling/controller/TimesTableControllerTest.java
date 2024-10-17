package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.TimesTableRequestDto;
import com.example.bus_timetabling.dto.TimesTableResponseDto;
import com.example.bus_timetabling.repository.TimesTableRepository;
import com.example.bus_timetabling.service.TimesTableService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TimesTableController.class)
public class TimesTableControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TimesTableService timesTableService;

    @MockBean
    private TimesTableRepository timesTableRepository;

    @Test
    public void testGetAllTimesTables() throws Exception {
        TimesTableResponseDto responseDto = new TimesTableResponseDto(
                1L,
                LocalTime.of(14, 8, 0),
                LocalTime.of(14, 10, 30),
                12.5,
                1L,
                "Bus 27",
                2L,
                "Stop A",
                3L,
                "Stop B"
        );
        List<TimesTableResponseDto> responseList = Arrays.asList(responseDto);

        Mockito.when(timesTableService.getAllTimesTables()).thenReturn(responseList);

        mockMvc.perform(get("/api/timetables")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].busNumber", is("Bus 27")))
                .andExpect(jsonPath("$[0].fromStopName", is("Stop A")))
                .andExpect(jsonPath("$[0].toStopName", is("Stop B")));
    }

    @Test
    public void testCreateTimesTable() throws Exception {
        TimesTableRequestDto requestDto = new TimesTableRequestDto(
                LocalTime.of(14, 8, 0),
                LocalTime.of(14, 10, 30),
                1L,
                2L,
                3L
        );

        TimesTableResponseDto responseDto = new TimesTableResponseDto(
                1L,
                requestDto.getDeparture(),
                requestDto.getArrival(),
                12.5,
                requestDto.getBusId(),
                "Bus 27",
                requestDto.getFromStopId(),
                "Stop A",
                requestDto.getToStopId(),
                "Stop B"
        );

        Mockito.when(timesTableService.createTimesTable(Mockito.any(TimesTableRequestDto.class)))
                .thenReturn(responseDto);

        String jsonContent = """
                {
                    "departure": "14:08:00",
                    "arrival": "14:10:30",
                    "busId": 1,
                    "fromStopId": 2,
                    "toStopId": 3
                }
                """;

        mockMvc.perform(post("/api/timetables")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.busNumber", is("Bus 27")))
                .andExpect(jsonPath("$.fromStopName", is("Stop A")))
                .andExpect(jsonPath("$.toStopName", is("Stop B")));
    }

    @Test
    public void testGetTimesTableById() throws Exception {
        TimesTableResponseDto responseDto = new TimesTableResponseDto(
                1L,
                LocalTime.of(14, 8, 0),
                LocalTime.of(14, 10, 30),
                12.5,
                1L,
                "Bus 27",
                2L,
                "Stop A",
                3L,
                "Stop B"
        );

        Mockito.when(timesTableService.getTimesTableById(1L)).thenReturn(responseDto);

        mockMvc.perform(get("/api/timetables/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.busNumber", is("Bus 27")))
                .andExpect(jsonPath("$.fromStopName", is("Stop A")))
                .andExpect(jsonPath("$.toStopName", is("Stop B")));
    }

    @Test
    public void testDeleteTimesTable() throws Exception {
        Mockito.doNothing().when(timesTableService).deleteTimesTable(1L);
        mockMvc.perform(delete("/api/timetables/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.doThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "TimesTable not found with id: 1"))
                .when(timesTableService).deleteTimesTable(1L);

        mockMvc.perform(delete("/api/timetables/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", containsString("TimesTable not found with id: 1")));

    }


    @Test
    public void testCreateTimesTable_MissingBusId() throws Exception {
        String jsonContent = """
                {
                    "departure": "14:08:00",
                    "arrival": "14:10:30",
                    "fromStopId": 2,
                    "toStopId": 3
                }
                """;

        mockMvc.perform(post("/api/timetables")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetTimesTableById_NotFound() throws Exception {
        Mockito.when(timesTableService.getTimesTableById(100L))
                .thenThrow(new RuntimeException("TimesTable not found"));

        mockMvc.perform(get("/api/timetables/100")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is("TimesTable not found")));
    }

    @Test
    public void testUpdateTimesTable_InvalidTimes() throws Exception {
        String jsonContent = """
                {
                    "departure": "14:10:30",
                    "arrival": "14:08:00",
                    "busId": 1,
                    "fromStopId": 2,
                    "toStopId": 3
                }
                """;

        mockMvc.perform(put("/api/timetables/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testDeleteTimesTable_Twice() throws Exception {
        Mockito.doNothing().when(timesTableService).deleteTimesTable(1L);
        mockMvc.perform(delete("/api/timetables/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.doThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "TimesTable not found with id: 1"))
                .when(timesTableService).deleteTimesTable(1L);

        mockMvc.perform(delete("/api/timetables/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", containsString("TimesTable not found with id: 1")));
    }


    @Test
    public void testGetTimesTablesByBusId_NotFound() throws Exception {
        Mockito.when(timesTableService.getTimesTablesByBusId(100L))
                .thenReturn(List.of());

        mockMvc.perform(get("/api/timetables/bus/100")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
