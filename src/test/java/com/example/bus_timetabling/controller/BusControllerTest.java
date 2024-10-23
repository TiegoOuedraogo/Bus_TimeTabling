package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.dto.BusRequestDto;
import com.example.bus_timetabling.dto.BusResponseDto;
import com.example.bus_timetabling.service.BusService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BusControllerTest.class)
class BusControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BusService busService;

    @Test
    void testCreateBus() throws Exception {
        BusRequestDto requestDto = new BusRequestDto();

    }

    @Test
    void findBusById() throws Exception {
        BusResponseDto responseDto = new BusResponseDto();
    }

    @Test
    void findBusByNumber() {
    }

    @Test
    void getAllBuses() {
    }

    @Test
    void findBusByRouteId() {
    }
}