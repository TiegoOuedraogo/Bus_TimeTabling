-- Create schema if not exists
CREATE SCHEMA IF NOT EXISTS bus_timetabling;

SET search_path TO bus_timetabling;

CREATE TABLE IF NOT EXISTS buses (
     bus_id SERIAL PRIMARY KEY,
     number VARCHAR(255) NOT NULL,
     capacity INTEGER NOT NULL,
     status varchar(255) NOT NULL,
     route_id BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS routes (
  route_id SERIAL PRIMARY KEY,
  route_name VARCHAR(255) NOT NULL,
  origin VARCHAR(255) NOT NULL,
  destination VARCHAR(255) NOT NULL,
  distance DOUBLE PRECISION
);

CREATE TABLE IF NOT EXISTS stops (
     stop_id SERIAL PRIMARY KEY,
     stop_name VARCHAR(255) NOT NULL,
     order_in_route INTEGER,
     route_id BIGINT
);

CREATE TABLE IF NOT EXISTS times_tables (
    times_table_id PRIMARY KEY,
    departure TIME NOT NULL,
    arrival TIME NOT NULL,
    segment_distance DOUBLE PRECISION,
    bus_id BIGINT,
    from_stop_id BIGINT,
    to_stop_id BIGINT
);

-- IF NOT EXISTS
--ALTER TABLE times_tables ADD CONSTRAINT
--fk_bus_id FOREIGN KEY (bus_id) REFERENCES buses (bus_id) ON DELETE CASCADE;
--
--ALTER TABLE times_tables ADD CONSTRAINT
--fk_from_stop_id FOREIGN KEY (from_stop_id) REFERENCES stops (stop_id) ON DELETE CASCADE;
--
--ALTER TABLE times_tables ADD CONSTRAINT
--fk_to_stop_id FOREIGN KEY (to_stop_id) REFERENCES stops (stop_id) ON DELETE CASCADE;
--
--ALTER TABLE stops ADD CONSTRAINT
--fk_route_id FOREIGN KEY (route_id) REFERENCES routes (route_id) ON DELETE CASCADE;
--
--ALTER TABLE routes ADD CONSTRAINT
--fk_origin_stop_id FOREIGN KEY (origin) REFERENCES stops (stop_id) ON DELETE CASCADE;
--
--ALTER TABLE routes ADD CONSTRAINT
--fk_destination_stop_id FOREIGN KEY (destination) REFERENCES stops (stop_id) ON DELETE CASCADE;
