INSERT INTO bus_timetabling.bus_route_manager (bus_route_id)
VALUES (1),
       (2),
       (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9),
       (10)
    ON CONFLICT DO NOTHING;

INSERT INTO bus_timetabling.routes (route_id, route_name, distance, bus_route_id)
VALUES (1, 'Route 101', 12.5, 1),
       (2, 'Route 102', 15.0, 2),
       (3, 'Route 103', 8.3, 3),
       (4, 'Route 104', 22.7, 4),
       (5, 'Route 105', 10.4, 5),
       (6, 'Route 106', 14.2, 6),
       (7, 'Route 107', 17.1, 7),
       (8, 'Route 108', 9.8, 8),
       (9, 'Route 109', 25.5, 9),
       (10, 'Route 110', 11.6, 10)
    ON CONFLICT DO NOTHING;

INSERT INTO bus_timetabling.stops (stop_id, stop_name)
VALUES (1, 'Central Station'),
       (2, 'East End'),
       (3, 'West Point'),
       (4, 'North Park'),
       (5, 'South Terminal'),
       (6, 'Greenfield'),
       (7, 'Lake View'),
       (8, 'Hilltop'),
       (9, 'Downtown'),
       (10, 'Airport')
    ON CONFLICT DO NOTHING;

INSERT INTO bus_timetabling.route_stop_schedule (route_stop_id, stop_num, route_id, stop_id)
VALUES (1, 1, 1, 1),
       (2, 2, 1, 2),
       (3, 3, 1, 3),
       (4, 1, 2, 4),
       (5, 2, 2, 5),
       (6, 3, 2, 6),
       (7, 1, 3, 7),
       (8, 2, 3, 8),
       (9, 3, 3, 9),
       (10, 1, 4, 10)
    ON CONFLICT DO NOTHING;

INSERT INTO bus_timetabling.buses (bus_id, bus_number, status, times_table_id, route_schedule_id)
VALUES (1, 'Bus 01', 'INSERVICE', 1, 1),
       (2, 'Bus 02', 'OUTOFSERVICE', 2, 2),
       (3, 'Bus 03', 'INSERVICE', 3, 3),
       (4, 'Bus 04', 'INSERVICE', 4, 4),
       (5, 'Bus 05', 'OUTOFSERVICE', 5, 5),
       (6, 'Bus 06', 'INSERVICE', 6, 6),
       (7, 'Bus 07', 'INSERVICE', 7, 7),
       (8, 'Bus 08', 'OUTOFSERVICE', 8, 8),
       (9, 'Bus 09', 'INSERVICE', 9, 9),
       (10, 'Bus 10', 'INSERVICE', 10, 10)
    ON CONFLICT DO NOTHING;

INSERT INTO bus_timetabling.times_tables (times_table_id, from_stop_id, to_stop_id, departure, arrival, bus_id)
VALUES (1, 1, 2, '08:00', '08:30', 1),
       (2, 2, 3, '09:00', '09:30', 2),
       (3, 3, 4, '10:00', '10:30', 3),
       (4, 4, 5, '11:00', '11:30', 4),
       (5, 5, 6, '12:00', '12:30', 5),
       (6, 6, 7, '13:00', '13:30', 6),
       (7, 7, 8, '14:00', '14:30', 7),
       (8, 8, 9, '15:00', '15:30', 8),
       (9, 9, 10, '16:00', '16:30', 9),
       (10, 10, 1, '17:00', '17:30', 10),
       (11, 6, 10, '13:00', '13:30', 6),
       (12, 7, 10, '14:00', '14:30', 7),
       (13, 8, 9, '15:00', '15:30', 1),
       (14, 2, 9, '16:00', '16:30', 3),
       (15, 10, 1, '17:00', '17:30', 10)
    ON CONFLICT DO NOTHING;

--
-- -- Insert into bus_route_manager
-- INSERT INTO bus_timetabling.bus_route_manager (bus_route_id)
-- VALUES (1), (2), (3), (4), (5), (6), (7), (8), (9), (10)
--     ON CONFLICT DO NOTHING;
--
-- -- Insert into routes, referencing bus_route_id from bus_route_manager
-- INSERT INTO bus_timetabling.routes (route_id, route_name, distance, bus_route_id)
-- VALUES (1, 'Route 101', 12.5, 1),
--        (2, 'Route 102', 15.0, 2),
--        (3, 'Route 103', 8.3, 3),
--        (4, 'Route 104', 22.7, 4),
--        (5, 'Route 105', 10.4, 5),
--        (6, 'Route 106', 14.2, 6),
--        (7, 'Route 107', 17.1, 7),
--        (8, 'Route 108', 9.8, 8),
--        (9, 'Route 109', 25.5, 9),
--        (10, 'Route 110', 11.6, 10)
--     ON CONFLICT DO NOTHING;
--
-- -- Insert into stops table
-- INSERT INTO bus_timetabling.stops (stop_id, stop_name)
-- VALUES (1, 'Central Station'),
--        (2, 'East End'),
--        (3, 'West Point'),
--        (4, 'North Park'),
--        (5, 'South Terminal'),
--        (6, 'Greenfield'),
--        (7, 'Lake View'),
--        (8, 'Hilltop'),
--        (9, 'Downtown'),
--        (10, 'Airport')
--     ON CONFLICT DO NOTHING;
--
-- -- Insert into route_stop_schedule with references to route_id and stop_id
-- INSERT INTO bus_timetabling.route_stop_schedule (route_stop_id, stop_num, route_id, stop_id)
-- VALUES (1, 1, 1, 1),
--        (2, 2, 1, 2),
--        (3, 3, 1, 3),
--        (4, 1, 2, 4),
--        (5, 2, 2, 5),
--        (6, 3, 2, 6),
--        (7, 1, 3, 7),
--        (8, 2, 3, 8),
--        (9, 3, 3, 9),
--        (10, 1, 4, 10)
--     ON CONFLICT DO NOTHING;
--
-- -- Insert into times_tables with references to from_stop_id and to_stop_id
-- INSERT INTO bus_timetabling.times_tables (times_table_id, from_stop_id, to_stop_id, departure, arrival, bus_id, route_id)
-- VALUES (1, 1, 2, '08:00', '08:30', NULL, 1),
--        (2, 2, 3, '09:00', '09:30', NULL, 2),
--        (3, 3, 4, '10:00', '10:30', NULL, 3),
--        (4, 4, 5, '11:00', '11:30', NULL, 4),
--        (5, 5, 6, '12:00', '12:30', NULL, 5),
--        (6, 6, 7, '13:00', '13:30', NULL, 6),
--        (7, 7, 8, '14:00', '14:30', NULL, 7),
--        (8, 8, 9, '15:00', '15:30', NULL, 8),
--        (9, 9, 10, '16:00', '16:30', NULL, 9),
--        (10, 10, 1, '17:00', '17:30', NULL, 10)
--     ON CONFLICT DO NOTHING;
--
-- -- Insert into buses after times_tables is populated, referencing times_table_id and route_schedule_id
-- INSERT INTO bus_timetabling.buses (bus_id, bus_number, status, times_table_id, route_schedule_id)
-- VALUES (1, 'Bus 01', 'INSERVICE', 1, 1),
--        (2, 'Bus 02', 'OUTOFSERVICE', 2, 2),
--        (3, 'Bus 03', 'INSERVICE', 3, 3),
--        (4, 'Bus 04', 'INSERVICE', 4, 4),
--        (5, 'Bus 05', 'OUTOFSERVICE', 5, 5),
--        (6, 'Bus 06', 'INSERVICE', 6, 6),
--        (7, 'Bus 07', 'INSERVICE', 7, 7),
--        (8, 'Bus 08', 'OUTOFSERVICE', 8, 8),
--        (9, 'Bus 09', 'INSERVICE', 9, 9),
--        (10, 'Bus 10', 'INSERVICE', 10, 10)
--     ON CONFLICT DO NOTHING;
