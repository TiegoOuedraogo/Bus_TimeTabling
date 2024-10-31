INSERT INTO bus_timetabling.routes (route_name, distance)
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
    ('Route J', 6.9);

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
    ('Stop 10');

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
    ('Bus 109', 'Active', 10);

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
