CREATE SCHEMA IF NOT EXISTS bus_timetabling;

CREATE TABLE IF NOT EXISTS bus_timetabling.buses (
       bus_id SERIAL PRIMARY KEY,
       bus_number VARCHAR(255),
       status VARCHAR(255),
       times_table_id BIGINT,
--        bus_route_id BIGINT
        route_schedule_id BIGINT
);

CREATE TABLE IF NOT EXISTS bus_timetabling.stops (
       stop_id SERIAL PRIMARY KEY,
       stop_name VARCHAR(255),
       route_stop_id BIGINT
);

CREATE TABLE IF NOT EXISTS bus_timetabling.bus_route_manager (
       bus_route_id SERIAL PRIMARY KEY

);

CREATE TABLE IF NOT EXISTS bus_timetabling.route_stop_schedule (
         route_stop_id SERIAL PRIMARY KEY,
         stop_num INT,
         route_id BIGINT,
         stop_id BIGINT
);

CREATE TABLE IF NOT EXISTS bus_timetabling.routes (
        route_id SERIAL PRIMARY KEY,
        route_name VARCHAR(255),
        distance DOUBLE PRECISION,
        bus_route_id BIGINT,
        route_stop_id BIGINT
        );

CREATE TABLE IF NOT EXISTS bus_timetabling.times_tables (
      times_table_id SERIAL PRIMARY KEY,
      from_stop_id BIGINT,
      to_stop_id BIGINT,
      departure TIME,
      arrival TIME,
      bus_id BIGINT
);

-- ALTER TABLE bus_timetabling.buses
--     ADD COLUMN route_schedule_id BIGINT;
