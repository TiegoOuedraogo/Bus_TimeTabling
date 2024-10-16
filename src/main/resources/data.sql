-- Insert into buses
INSERT INTO buses (bus_id, number, capacity, status, route_id)
VALUES (1, 'Q22', 25, "INSERVICE", 1)
ON CONFLICT (full_name) DO NOTHING;

INSERT INTO buses (bus_id, number, capacity, status, route_id)
VALUES (2, 'B42', 25, "INSERVICE", 4)
ON CONFLICT (full_name) DO NOTHING;

INSERT INTO buses (bus_id, number, capacity, status, route_id)
VALUES (3, 'M94', 25, "INSERVICE", 2)
ON CONFLICT (full_name) DO NOTHING;

INSERT INTO buses (bus_id, number, capacity, status, route_id)
VALUES (4, 'S53', 25, "INSERVICE", 5)
ON CONFLICT (full_name) DO NOTHING;

INSERT INTO buses (bus_id, number, capacity, status, route_id)
VALUES (5, 'Bx7', 25, "INSERVICE", 3)
ON CONFLICT (full_name) DO NOTHING;


-- Insert into stops
--Queens Stops
INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(1, "Lefferts BLVD", 1)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(2, "Jamaica AVE", 1)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(3, "Rockaway BLVD", 1)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(4, "111th Street", 1)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(5, "Steinway Street", 1)
ON CONFLICT (account_number) DO NOTHING;

--Manhattan Stops
INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(6, "Lafayette Street", 2)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(7, "Broadway", 2)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(8, "Lexingston AVE", 2)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(9, "E42 Street", 2)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(10, "Park AVE", 2)
ON CONFLICT (account_number) DO NOTHING;

--Bronx Stops
INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(11, "Jerome AVE", 3)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(12, "Fordham RD", 3)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(13, "Pelham PKWY", 3)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(14, "Westchester AVE", 3)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(15, "White Plains RD", 3)
ON CONFLICT (account_number) DO NOTHING;

--Brooklyn Stops
INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(16, "Bedford AVE", 4)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(17, "Flatbush AVE", 4)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(18, "Canal Street", 4)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(19, "Myrtle AVE", 4)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(20, "Malcolm X BLVD", 4)
ON CONFLICT (account_number) DO NOTHING;

--Staten Island Stops
INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(21, "Ocean Terrace", 5)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(22, "Richmond RD", 5)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(23, "Tysens LN", 5)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(24, "Ebbitts Street", 5)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops (stop_id, stop_name, route_id)
VALUES
(25, "Olympia BLVD", 5)
ON CONFLICT (account_number) DO NOTHING;

-- Insert into routes
INSERT INTO routes (route_id, route_name, origin, destination, distance)
VALUES
(1, "Ozone Park-Astoria", "Lefferts BLVD", "Steinway Street", 23)
ON CONFLICT DO NOTHING;

INSERT INTO routes (route_id, route_name, origin, destination, distance)
VALUES
(2, "Central Park Tour", "Lafayette Street", "Park AVE", 14)
ON CONFLICT DO NOTHING;

INSERT INTO routes (route_id, route_name, origin, destination, distance)
VALUES
(3, "Belmont Express", "Jerome AVE", "White Plains RD", 10)
ON CONFLICT DO NOTHING;

INSERT INTO routes (route_id, route_name, origin, destination, distance)
VALUES
(4, "Central Brooklyn Drive", "Bedford AVE", "Malcolm X BLVD", 7)
ON CONFLICT DO NOTHING;

INSERT INTO routes (route_id, route_name, origin, destination, distance)
VALUES
(5, "South TODT Hill Way", "Ocean Terrace", "Olympia BLVD", 3)
ON CONFLICT DO NOTHING;

-- Insert into times_tables
INSERT INTO times_tables (times_tables_id, departures, arrival, bus_id, stop_id)
VALUES()
ON CONFLICT DO NOTHING;