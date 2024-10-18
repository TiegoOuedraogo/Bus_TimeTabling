-- Insert into buses
INSERT INTO buses (bus_id, number, capacity, status, route_id)
VALUES
(1, 'Q22', 25, 'INSERVICE', 1),
(2, 'B42', 25, 'INSERVICE', 4),
(3, 'M94', 25, 'INSERVICE', 2),
(4, 'S53', 25, 'INSERVICE', 5),
(5, 'Bx7', 25, 'INSERVICE', 3)
ON CONFLICT DO NOTHING;


-- Insert into stops
--Queens Stops
INSERT INTO stops (stop_id, stop_name, order_in_route, route_id)
VALUES
(1, 'Lefferts BLVD',1, 1),
(2, 'Jamaica AVE',2, 1),
(3, 'Rockaway BLVD',3, 1),
(4, '111th Street',4, 1),
(5, 'Steinway Street',5, 1),

--Manhattan Stops
(6, 'Lafayette Street',1, 2),
(7, 'Broadway',2, 2),
(8, 'Lexingston AVE',3, 2),
(9, 'E42 Street',4, 2),
(10, 'Park AVE',5, 2),

--Bronx Stops
(11, 'Jerome AVE',1, 3),
(12, 'Fordham RD',2, 3),
(13, 'Pelham PKWY',3, 3),
(14, 'Westchester AVE',4, 3),
(15, 'White Plains RD',5, 3),

--Brooklyn Stops
(16, 'Bedford AVE',1, 4),
(17, 'Flatbush AVE',2, 4),
(18, 'Canal Street',3, 4),
(19, 'Myrtle AVE',4, 4),
(20, 'Malcolm X BLVD',5, 4),

--Staten Island Stops
(21, 'Ocean Terrace',1, 5),
(22, 'Richmond RD',2, 5),
(23, 'Tysens LN',3, 5),
(24, 'Ebbitts Street',4, 5),
(25, 'Olympia BLVD',5, 5)
ON CONFLICT DO NOTHING;

-- Insert into routes
INSERT INTO routes (route_id, route_name, origin, destination, distance)
VALUES
(1, 'Ozone Park-Astoria', 'Lefferts BLVD', 'Steinway Street', 23),
(2, 'Central Park Tour', 'Lafayette Street', 'Park AVE', 14),
(3, 'Belmont Express', 'Jerome AVE', 'White Plains RD', 10),
(4, 'Central Brooklyn Drive', 'Bedford AVE', 'Malcolm X BLVD', 7),
(5, 'South TODT Hill Way', 'Ocean Terrace', 'Olympia BLVD', 3)
ON CONFLICT DO NOTHING;

-- Insert into times_tables
-- times_tables dummy data
INSERT INTO times_tables (times_table_id, departure, arrival, segment_distance, bus_id, from_stop_id, to_stop_id)
VALUES
(1, '08:00:00', '08:15:00', 5.2, 1, 1, 2),
(2, '08:15:00', '08:35:00', 6.1, 1, 2, 3),
(3, '08:35:00', '08:50:00', 4.2, 1, 3, 4),
(4, '08:50:00', '09:05:00', 3.3, 1, 4, 5),
(5, '09:00:00', '09:20:00', 5.2, 2, 16, 17),
(6, '09:20:00', '09:40:00', 6.1, 2, 17, 18),
(7, '09:40:00', '09:55:00', 4.2, 2, 18, 19),
(8, '09:55:00', '10:10:00', 7.1, 2, 19,20),
(9, '08:30:00', '08:45:00', 3.5, 3, 6, 7),
(10, '08:45:00', '09:05:00', 3.7, 3, 7, 8),
(11, '10:00:00', '10:15:00', 2.8, 3, 8, 9),
(12, '10:15:00', '10:30:00', 2.9, 3, 9, 10),
(13, '15:15:00', '15:30:00', 1.7, 4, 21, 22),
(14, '15:30:00', '15:45:00', 2.2, 4, 22, 23),
(15, '15:45:00', '16:00:00', 2.4, 4, 23, 24),
(16, '16:00:00', '16:15:00', 2.1, 4, 24, 25),
(17, '12:15:00', '12:30:00', 5.1, 5, 11, 12),
(18, '12:30:00', '12:45:00', 6.1, 5, 12, 13),
(19, '12:45:00', '13:00:00', 3.8, 5, 13, 14),
(20, '13:00:00', '13:15:00', 7.7, 5, 14, 15)
ON CONFLICT DO NOTHING;