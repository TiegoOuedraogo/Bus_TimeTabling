SET search_path TO bus_timetabling;

INSERT INTO routes (route_name, origin, destination, distance) VALUES
   ('Route 1', 'City Center', 'Airport', 15.5),
   ('Route 2', 'Suburban Area', 'Downtown', 10.2),
   ('Route 3', 'University', 'Shopping Mall', 8.7);

INSERT INTO buses (number, capacity, status, route_id) VALUES
   ('Bus001', 50, 'INSERVICE', 1),
   ('Bus002', 40, 'INSERVICE', 1),
   ('Bus003', 60, 'INSERVICE', 2),
   ('Bus004', 45, 'OUTOFSERVICE', 3);

INSERT INTO stops (stop_name, order_in_route, route_id) VALUES
    ('City Center Station', 1, 1),
    ('Midtown Square', 2, 1),
    ('Business Park', 3, 1),
    ('Airport Terminal', 4, 1),
    ('Suburban Station', 1, 2),
    ('Central Park', 2, 2),
    ('Downtown Plaza', 3, 2),
    ('University Main Gate', 1, 3),
    ('Science Park', 2, 3),
    ('Shopping Mall Entrance', 3, 3);

-- times_tables dummy data
INSERT INTO times_tables (departure, arrival, segment_distance, bus_id, from_stop_id, to_stop_id) VALUES
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