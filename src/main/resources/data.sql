
INSERT INTO  bus_timetabling.routes (route_name, distance)
VALUES
    ('Route A', 10.5),
    ('Route B', 8.2),
    ('Route C', 12.0),
    ('Route D', 15.3),
    ('Route E', 9.7),
    ('Route F', 7.1),
    ('Route G', 13.8),
    ('Route H', 11.6),
    ('Route I', 14.4),
    ('Route J', 6.9)
ON CONFLICT DO NOTHING;

-- Insert Data into Stops
INSERT INTO bus_timetabling.stops (stop_name)
VALUES
    ('Stop 1'),
    ('Stop 2'),
    ('Stop 3'),
    ('Stop 4'),
    ('Stop 5'),
    ('Stop 6'),
    ('Stop 7'),
    ('Stop 8'),
    ('Stop 9'),
    ('Stop 10') ON CONFLICT DO NOTHING;

-- Insert Data into Buses
INSERT INTO bus_timetabling.buses (bus_number, status, route_id)
VALUES
    ('Bus 100', 'Active', 1),
    ('Bus 101', 'Active', 2),
    ('Bus 102', 'Inactive', 3),
    ('Bus 103', 'Active', 4),
    ('Bus 104', 'Maintenance', 5),
    ('Bus 105', 'Active', 6),
    ('Bus 106', 'Active', 7),
    ('Bus 107', 'Inactive', 8),
    ('Bus 108', 'Active', 9),
    ('Bus 109', 'Active', 10) ON CONFLICT DO NOTHING;

-- Insert Data into Route_Stops for Route 1
INSERT INTO bus_timetabling.route_stops (route_id, stop_id, stop_num)
VALUES
    (1, 1, 1),
    (1, 2, 2),
    (1, 3, 3),
    (1, 4, 4),
    (1, 5, 5) ON CONFLICT DO NOTHING;

-- Insert Data into Route_Stops for Route 2
INSERT INTO bus_timetabling.route_stops (route_id, stop_id, stop_num)
VALUES
    (2, 6, 1),
    (2, 7, 2),
    (2, 8, 3),
    (2, 9, 4),
    (2, 10, 5) ON CONFLICT DO NOTHING;

-- Insert Timetables for Bus 1 (B100)
INSERT INTO bus_timetabling.timetables (bus_id, stop_id, arrival, departure)
VALUES
    (1, 1, '08:00:00', '08:05:00'),
    (1, 2, '08:15:00', '08:20:00'),
    (1, 3, '08:30:00', '08:35:00'),
    (1, 4, '08:45:00', '08:50:00'),
    (1, 5, '09:00:00', '09:05:00') ON CONFLICT DO NOTHING;

-- Insert Timetables for Bus 2 (B101)
INSERT INTO bus_timetabling.timetables (bus_id, stop_id, arrival, departure)
VALUES
    (2, 6, '09:10:00', '09:15:00'),
    (2, 7, '09:25:00', '09:30:00'),
    (2, 8, '09:40:00', '09:45:00'),
    (2, 9, '09:55:00', '10:00:00'),
    (2, 10, '10:10:00', '10:15:00'),
    (3, 1, '08:00:00', '08:05:00'),
    (3, 2, '08:15:00', '08:20:00'),
    (3, 3, '08:30:00', '08:35:00'),
    (3, 4, '08:45:00', '08:50:00'),
    (3, 5, '09:00:00', '09:05:00'),
    (3, 1, '08:00:00', '08:05:00'),
    (3, 2, '08:15:00', '08:20:00'),
    (3, 4, '08:30:00', '08:35:00'),
    (3, 4, '08:45:00', '08:50:00'),
    (3, 5, '09:00:00', '09:05:00'),
    (4, 4, '09:10:00', '09:15:00'),
    (4, 4, '09:25:00', '09:30:00'),
    (4, 4, '09:40:00', '09:45:00'),
    (4, 4, '09:55:00', '10:00:00'),
    (4, 4, '10:10:00', '10:15:00'),

    (5, 5, '10:20:00', '10:25:00'),
    (5, 5, '10:35:00', '10:40:00'),
    (5, 5, '10:50:00', '10:55:00'),
    (5, 5, '11:05:00', '11:10:00'),
    (5, 5, '11:20:00', '11:25:00') ON CONFLICT DO NOTHING;
--
-- -- Insert Timetables for Bus 6 (B105)
-- INSERT INTO bus_timetabling.timetables (bus_id, stop_id, arrival, departure)
-- VALUES
--     (6, 26, '11:30:00', '11:35:00'),
--     (6, 27, '11:45:00', '11:50:00'),
--     (6, 28, '12:00:00', '12:05:00'),
--     (6, 29, '12:15:00', '12:20:00'),
--     (6, 30, '12:30:00', '12:35:00');
--
-- -- Insert Timetables for Bus 7 (B106)
-- INSERT INTO bus_timetabling.timetables (bus_id, stop_id, arrival, departure)
-- VALUES
--     (7, 31, '12:40:00', '12:45:00'),
--     (7, 32, '12:55:00', '13:00:00'),
--     (7, 33, '13:10:00', '13:15:00'),
--     (7, 34, '13:25:00', '13:30:00'),
--     (7, 35, '13:40:00', '13:45:00');
--
-- -- Insert Timetables for Bus 8 (B107)
-- INSERT INTO bus_timetabling.timetables (bus_id, stop_id, arrival, departure)
-- VALUES
--     (8, 36, '13:50:00', '13:55:00'),
--     (8, 37, '14:05:00', '14:10:00'),
--     (8, 38, '14:20:00', '14:25:00'),
--     (8, 39, '14:35:00', '14:40:00'),
--     (8, 40, '14:50:00', '14:55:00');
--
-- -- Insert Timetables for Bus 9 (B108)
-- INSERT INTO bus_timetabling.timetables (bus_id, stop_id, arrival, departure)
-- VALUES
--     (9, 41, '15:00:00', '15:05:00'),
--     (9, 42, '15:15:00', '15:20:00'),
--     (9, 43, '15:30:00', '15:35:00'),
--     (9, 44, '15:45:00', '15:50:00'),
--     (9, 45, '16:00:00', '16:05:00');
--
-- -- Insert Timetables for Bus 10 (B109)
-- INSERT INTO bus_timetabling.timetables (bus_id, stop_id, arrival, departure)
-- VALUES
--     (10, 46, '16:10:00', '16:15:00'),
--     (10, 47, '16:25:00', '16:30:00'),
--     (10, 48, '16:40:00', '16:45:00'),
--     (10, 49, '16:55:00', '17:00:00'),
--     (10, 50, '17:10:00', '17:15:00');
