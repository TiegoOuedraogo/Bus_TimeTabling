--INSERT INTO bus_timetabling.stops (stop_id, stop_name, route_stop_id)
--VALUES (1, 'Central Station', 1),
--       (2, 'East End', 1),
--       (3, 'West Point', 1);
--
--INSERT INTO bus_timetabling.routes (route_id, route_name, distance, bus_route_id)
--VALUES (1, 'Route 101', 12.5, 1);
--
--INSERT INTO bus_timetabling.buses (bus_id, bus_number, status, to_stop_id, from_stop_id, route_schedule_id)
--VALUES (1, 'Bus 01', 'INSERVICE', 1, 2, 1),
--       (2, 'Bus 02', 'OUTOFSERVICE', 2, 3, 1);
--
--INSERT INTO bus_timetabling.times_tables (times_table_id, from_stop_id, to_stop_id, departure, arrival, bus_id)
--VALUES (1, 1, 2, '08:00', '08:30', 1),
--       (2, 2, 3, '09:00', '09:30', 2);
--
--INSERT INTO bus_timetabling.route_stop_schedule (route_schedule_id, stop_num, route_id, stop_id)
--VALUES(1, 1, 1, 1),
--      (2, 2, 1, 2),
--      (3, 3, 1, 3);
--
--INSERT INTO bus_timetabling.bus_route_manager (bus_route_id)
--VALUES(1),
--      (2),
--      (3);

INSERT INTO bus_timetabling.bus_route_manager (bus_route_id)
VALUES (1),
       (2),
       (3);

INSERT INTO bus_timetabling.routes (route_id, route_name, distance, bus_route_id)
VALUES (1, 'Route 101', 12.5, 1);


INSERT INTO bus_timetabling.stops (stop_id, stop_name)
VALUES (1, 'Central Station'),
       (2, 'East End'),
       (3, 'West Point');

INSERT INTO bus_timetabling.route_stop_schedule (route_stop_id, stop_num, route_id, stop_id)
VALUES (1, 1, 1, 1),
       (2, 2, 1, 2),
       (3, 3, 1, 3);

INSERT INTO bus_timetabling.buses (bus_id, bus_number, status, to_stop_id, from_stop_id, route_schedule_id)
VALUES (1, 'Bus 01', 'INSERVICE', 1, 2, 1),
       (2, 'Bus 02', 'OUTOFSERVICE', 2, 3, 1);

INSERT INTO bus_timetabling.times_tables (times_table_id, from_stop_id, to_stop_id, departure, arrival, bus_id)
VALUES (1, 1, 2, '08:00', '08:30', 1),
       (2, 2, 3, '09:00', '09:30', 2);


