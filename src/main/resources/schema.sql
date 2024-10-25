CREATE SCHEMA IF NOT EXISTS bus_timetabling;

CREATE TABLE IF NOT EXISTS bus_timetabling.buses (
       bus_id SERIAL PRIMARY KEY,
       number VARCHAR(255),
       status VARCHAR(255),
       to_stop_id BIGINT,
       from_stop_id BIGINT,
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
        bus_route_id BIGINT
        );

CREATE TABLE IF NOT EXISTS bus_timetabling.times_tables (
      times_table_id SERIAL PRIMARY KEY,
      from_stop_id BIGINT,
      to_stop_id BIGINT,
      departure TIME,
      arrival TIME,
      bus_id BIGINT
);

CREATE TABLE IF NOT EXISTS bus_timetabling.route_stop_schedule (
      bus_route_id SERIAL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS bus_timetabling.bus_route_manager (
      route_schedule_id SERIAL PRIMARY KEY,
      stop_num int,
      route_id BIGINT,
      stop_id
);


-- ALTER TABLE  bus_timetabling.buses
--     ADD CONSTRAINT fk_to_stop FOREIGN KEY (to_stop_id) REFERENCES bus_timetabling.stops (stop_id),
--     ADD CONSTRAINT fk_from_stop FOREIGN KEY (from_stop_id) REFERENCES bus_timetabling.stops (stop_id),
--     ADD CONSTRAINT fk_route_schedule FOREIGN KEY (route_schedule_id) REFERENCES bus_timetabling.bus_route_manager (bus_route_id);
--
-- ALTER TABLE bus_timetabling.stops
--     ADD CONSTRAINT fk_route_stop FOREIGN KEY (route_stop_id) REFERENCES bus_timetabling.route_stop_schedule (route_stop_id);
--
-- ALTER TABLE bus_timetabling.route_stop_schedule
--     ADD CONSTRAINT fk_route FOREIGN KEY (route_id) REFERENCES bus_timetabling.routes (route_id),
--     ADD CONSTRAINT fk_stop FOREIGN KEY (stop_id) REFERENCES bus_timetabling.stops (stop_id);
--
-- ALTER TABLE bus_timetabling.routes
--     ADD CONSTRAINT fk_bus_route_manager FOREIGN KEY (bus_route_id) REFERENCES bus_timetabling.bus_route_manager (bus_route_id);
--
-- ALTER TABLE bus_timetabling.times_tables
--     ADD CONSTRAINT fk_from_stop FOREIGN KEY (from_stop_id) REFERENCES bus_timetabling.stops (stop_id),
--     ADD CONSTRAINT fk_to_stop FOREIGN KEY (to_stop_id) REFERENCES bus_timetabling.stops (stop_id),
--     ADD CONSTRAINT fk_bus FOREIGN KEY (bus_id) REFERENCES bus_timetabling.buses (bus_id);
