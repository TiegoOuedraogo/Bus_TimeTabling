//package com.example.bus_timetabling.service;
//
//import com.example.bus_timetabling.entities.Bus;
//import com.example.bus_timetabling.entities.Route;
//import com.example.bus_timetabling.entities.Timetable;
//import com.example.bus_timetabling.repository.BusRepository;
//import com.example.bus_timetabling.repository.RouteRepository;
//import com.example.bus_timetabling.repository.TimetableRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.time.LocalTime;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class BusServiceTest {
//    @Mock
//    private BusRepository busRepository;
//
//    @Mock
//    private RouteRepository routeRepository;
//
//    @Mock
//    private TimetableRepository timesTableRepository;
//
//    @InjectMocks
//    private BusService busService;
//
//    private Bus validBus;
//    private Route validRoute;
//    private Timetable validTimesTable;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        validBus = new Bus();
//        validBus.setId(1L);
//        validRoute = new Route();
//        validRoute.setId(1L);
//        validTimesTable = new Timetable();
//        validTimesTable.setBus(validBus);
//        validTimesTable.setDepartures(LocalTime.of(14, 8, 0, 0)),
//        validTimesTable.setArrival(LocalTime.of(4,45,5)),
//        validTimesTable.setStop("stop","");
//    }
//
//    @Test
//    void createBus() {
//    }
//
//    @Test
//    void findBusById() {
//    }
//
//    @Test
//    void findBusByNumber() {
//    }
//
//    @Test
//    void getAllBuses() {
//    }
//
//    @Test
//    void findBusByRouteId() {
//    }
//
//    @Test
//    void updateBus() {
//    }
//}
