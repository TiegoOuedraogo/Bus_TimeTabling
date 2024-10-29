CREATE SCHEMA IF NOT EXISTS bus_timetabling;

CREATE TABLE IF NOT EXISTS bus_timetabling.buses (
       bus_id SERIAL PRIMARY KEY,
       bus_number VARCHAR(255),
       status VARCHAR(255),
       times_table_id BIGINT,
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


-- CREATE SCHEMA IF NOT EXISTS bus_timetabling;
--
-- -- Create the stops table
-- CREATE TABLE IF NOT EXISTS bus_timetabling.stops (
--                                                      stop_id SERIAL PRIMARY KEY,
--                                                      stop_name VARCHAR(255)
-- );
--
-- -- Create the bus_route_manager table
-- CREATE TABLE IF NOT EXISTS bus_timetabling.bus_route_manager (
--                                                                  bus_route_id SERIAL PRIMARY KEY
-- );
--
-- -- Create the routes table with a foreign key referencing bus_route_manager
-- CREATE TABLE IF NOT EXISTS bus_timetabling.routes (
--                                                       route_id SERIAL PRIMARY KEY,
--                                                       route_name VARCHAR(255),
--                                                       distance DOUBLE PRECISION,
--                                                       bus_route_id BIGINT,
--                                                       route_stop_id BIGINT,
--                                                       FOREIGN KEY (bus_route_id) REFERENCES bus_timetabling.bus_route_manager(bus_route_id) ON DELETE SET NULL
-- );
--
-- -- Create the route_stop_schedule table with foreign keys referencing routes and stops
-- CREATE TABLE IF NOT EXISTS bus_timetabling.route_stop_schedule (
--                                                                    route_stop_id SERIAL PRIMARY KEY,
--                                                                    stop_num INT,
--                                                                    route_id BIGINT,
--                                                                    stop_id BIGINT,
--                                                                    FOREIGN KEY (route_id) REFERENCES bus_timetabling.routes(route_id) ON DELETE CASCADE,
--                                                                    FOREIGN KEY (stop_id) REFERENCES bus_timetabling.stops(stop_id) ON DELETE CASCADE
-- );
--
-- -- Create the times_tables table with foreign keys referencing stops
-- CREATE TABLE IF NOT EXISTS bus_timetabling.times_tables (
--                                                             times_table_id SERIAL PRIMARY KEY,
--                                                             from_stop_id BIGINT,
--                                                             to_stop_id BIGINT,
--                                                             departure TIME,
--                                                             arrival TIME,
--                                                             bus_id BIGINT,
--                                                             route_id BIGINT,
--                                                             FOREIGN KEY (from_stop_id) REFERENCES bus_timetabling.stops(stop_id) ON DELETE SET NULL,
--                                                             FOREIGN KEY (to_stop_id) REFERENCES bus_timetabling.stops(stop_id) ON DELETE SET NULL
-- );
--
-- -- Create the buses table with foreign keys referencing times_tables and route_stop_schedule
-- CREATE TABLE IF NOT EXISTS bus_timetabling.buses (
--                                                      bus_id SERIAL PRIMARY KEY,
--                                                      bus_number VARCHAR(255),
--                                                      status VARCHAR(255),
--                                                      times_table_id BIGINT,
--                                                      route_schedule_id BIGINT,
--                                                      FOREIGN KEY (times_table_id) REFERENCES bus_timetabling.times_tables(times_table_id) ON DELETE SET NULL,
--                                                      FOREIGN KEY (route_schedule_id) REFERENCES bus_timetabling.route_stop_schedule(route_stop_id) ON DELETE SET NULL
-- );
