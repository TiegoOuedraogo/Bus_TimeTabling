INSERT INTO bus_timetabling.routes (route_name, distance)
VALUES
('B1 - Myrtle Ave to Downtown Brooklyn', 12.5),
('B2 - Atlantic Ave to Coney Island', 15.8),
('B3 - Bedford Ave to Borough Park', 10.3),
('B4 - Flatbush Ave to Bay Ridge', 14.2),
('B5 - Fulton St to Greenpoint', 11.6),
('B6 - Myrtle Ave to Park Slope', 13.4),
('B7 - Kingston Ave to Sunset Park', 9.9),
('B8 - Nostrand Ave to Crown Heights', 8.7),
('B9 - Brooklyn Heights to Red Hook', 7.5),
('B10 - Fulton Mall to DUMBO', 6.8);

-- Insert Data into Stops
INSERT INTO bus_timetabling.stops (stop_name)
VALUES
('Atlantic Ave & Flatbush Ave'),
('Brooklyn Bridge Park Pier 6'),
('Barclays Center'),
('Prospect Park West & 15th St'),
('Dekalb Ave & Fulton St'),
('Myrtle Ave & Broadway'),
('Carroll Gardens & Smith St'),
('Nostrand Ave & Classon Ave'),
('Brooklyn Heights Promenade'),
('Red Hook Terminal');

-- Insert Data into Buses
INSERT INTO bus_timetabling.buses (bus_number, status, route_id)
VALUES
('B100', 'Active', 1),
('B101', 'Active', 2),
('B102', 'Inactive', 3),
('B103', 'Active', 4),
('B104', 'Maintenance', 5),
('B105', 'Active', 6),
('B106', 'Active', 7),
('B107', 'Inactive', 8),
('B108', 'Active', 9),
('B109', 'Active', 10);

-- Insert Data into Route_Stops for Route 1
INSERT INTO bus_timetabling.route_stops (route_id, stop_id, stop_num)
VALUES
(1, 1, 1),
(1, 2, 2),
(1, 3, 3),
(1, 4, 4),
(1, 5, 5);

-- Insert Data into Route_Stops for Route 2
INSERT INTO bus_timetabling.route_stops (route_id, stop_id, stop_num)
VALUES
(2, 6, 1),
(2, 7, 2),
(2, 8, 3),
(2, 9, 4),
(2, 10, 5);

-- Insert Data into Timetables for Bus 1
INSERT INTO bus_timetabling.timetables (bus_id, stop_id, arrival, departure)
VALUES
(1, 1, '08:00:00', '08:05:00'),
(1, 2, '08:15:00', '08:20:00'),
(1, 3, '08:30:00', '08:35:00'),
(1, 4, '08:45:00', '08:50:00'),
(1, 5, '09:00:00', '09:05:00');

-- Insert Data into Timetables for Bus 2
INSERT INTO bus_timetabling.timetables (bus_id, stop_id, arrival, departure)
VALUES
(2, 6, '09:10:00', '09:15:00'),
(2, 7, '09:25:00', '09:30:00'),
(2, 8, '09:40:00', '09:45:00'),
(2, 9, '09:55:00', '10:00:00'),
(2, 10, '10:10:00', '10:15:00');






package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.entities.Bus;
import com.example.bus_timetabling.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    private final BusRepository busRepository;

    @Autowired
    public BusController(BusRepository busRepository) {
        this.busRepository = busRepository;
    }
    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses() {
        List<Bus> buses = busRepository.findAll();
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        return busRepository.findById(id)
                .map(bus -> ResponseEntity.ok(bus))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
        Bus savedBus = busRepository.save(bus);
        return ResponseEntity.ok(savedBus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody Bus busDetails) {
        return busRepository.findById(id)
                .map(bus -> {
                    bus.setBusNumber(busDetails.getBusNumber());
                    bus.setStatus(busDetails.getStatus());
                    bus.setRoute(busDetails.getRoute());
                    Bus updatedBus = busRepository.save(bus);
                    return ResponseEntity.ok(updatedBus);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
        return busRepository.findById(id)
                .map(bus -> {
                    busRepository.delete(bus);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
