-- Insert into buses
INSERT INTO buses ( number, capacity, status, route_id)
VALUES ( 'Q22', 25, "INSERVICE", 1)
ON CONFLICT (full_name) DO NOTHING;

INSERT INTO buses ( number, capacity, status, route_id)
VALUES ( 'B42', 25, "INSERVICE", 4)
ON CONFLICT (full_name) DO NOTHING;

INSERT INTO buses ( number, capacity, status, route_id)
VALUES ( 'M94', 25, "INSERVICE", 2)
ON CONFLICT (full_name) DO NOTHING;

INSERT INTO buses ( number, capacity, status, route_id)
VALUES ( 'S53', 25, "INSERVICE", 5)
ON CONFLICT (full_name) DO NOTHING;

INSERT INTO buses ( number, capacity, status, route_id)
VALUES ( 'Bx7', 25, "INSERVICE", 3)
ON CONFLICT (full_name) DO NOTHING;


-- Insert into stops
--Queens Stops
INSERT INTO stops ( stop_name, order_in_route, route_id)
VALUES
( "Lefferts BLVD",1, 1)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Jamaica AVE",2, 1)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Rockaway BLVD",3, 1)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "111th Street",4, 1)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Steinway Street",5, 1)
ON CONFLICT (account_number) DO NOTHING;

--Manhattan Stops
INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Lafayette Street",1, 2)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Broadway",2, 2)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Lexingston AVE",3, 2)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "E42 Street",4, 2)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Park AVE",5, 2)
ON CONFLICT (account_number) DO NOTHING;

--Bronx Stops
INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Jerome AVE",1, 3)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Fordham RD",2, 3)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Pelham PKWY",3, 3)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Westchester AVE",4, 3)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "White Plains RD",5, 3)
ON CONFLICT (account_number) DO NOTHING;

--Brooklyn Stops
INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Bedford AVE",1, 4)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Flatbush AVE",2, 4)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Canal Street",3, 4)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Myrtle AVE",4, 4)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Malcolm X BLVD",5, 4)
ON CONFLICT (account_number) DO NOTHING;

--Staten Island Stops
INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Ocean Terrace",1, 5)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Richmond RD",2, 5)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Tysens LN",3, 5)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name,order_in_route, route_id)
VALUES
( "Ebbitts Street",4, 5)
ON CONFLICT (account_number) DO NOTHING;

INSERT INTO stops ( stop_name, order_in_route,route_id)
VALUES
( "Olympia BLVD",5, 5)
ON CONFLICT (account_number) DO NOTHING;

-- Insert into routes
INSERT INTO routes ( route_name, origin, destination, distance)
VALUES
( "Ozone Park-Astoria", "Lefferts BLVD", "Steinway Street", 23)
ON CONFLICT DO NOTHING;

INSERT INTO routes ( route_name, origin, destination, distance)
VALUES
( "Central Park Tour", "Lafayette Street", "Park AVE", 14)
ON CONFLICT DO NOTHING;

INSERT INTO routes ( route_name, origin, destination, distance)
VALUES
( "Belmont Express", "Jerome AVE", "White Plains RD", 10)
ON CONFLICT DO NOTHING;

INSERT INTO routes ( route_name, origin, destination, distance)
VALUES
( "Central Brooklyn Drive", "Bedford AVE", "Malcolm X BLVD", 7)
ON CONFLICT DO NOTHING;

INSERT INTO routes ( route_name, origin, destination, distance)
VALUES
( "South TODT Hill Way", "Ocean Terrace", "Olympia BLVD", 3)
ON CONFLICT DO NOTHING;

-- Insert into times_tables
-- times_tables dummy data
INSERT INTO times_tables ( departure, arrival, segment_distance, bus_id, from_stop_id, to_stop_id) VALUES
      ('08:00:00', '08:15:00', 5.2, 1, 1, 2),
      ('08:15:00', '08:35:00', 6.1, 1, 2, 3),
      ('08:35:00', '08:50:00', 4.2, 1, 3, 4),
      ('09:00:00', '09:20:00', 5.2, 2, 1, 2),
      ('09:20:00', '09:40:00', 6.1, 2, 2, 3),
      ('09:40:00', '09:55:00', 4.2, 2, 3, 4),
      ('08:30:00', '08:45:00', 3.5, 3, 5, 6),
      ('08:45:00', '09:05:00', 3.7, 3, 6, 7),
      ('10:00:00', '10:15:00', 2.8, 4, 8, 9),
      ('10:15:00', '10:30:00', 2.9, 4, 9, 10);