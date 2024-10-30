SELECT * FROM bus_timetabling.times_tables
WHERE to_stop_id = 1 AND arrival > '07:50'
ORDER BY arrival ASC
    LIMIT 3;

SELECT * FROM bus_timetabling.times_tables
WHERE route_id = 2 AND departure > '07:30:00'
ORDER BY departure ASC
LIMIT 1;


select tt1_0.times_table_id,tt1_0.arrival,tt1_0.departure,tt1_0.from_stop_id,tt1_0.route_id,tt1_0.to_stop_id
from bus_timetabling.times_tables tt1_0
where tt1_0.route_id=1
  and tt1_0.departure>'07:30:00'
order by tt1_0.departure;


SELECT t FROM bus_timetabling.times_tables t WHERE from_stop_id = :stopX OR to_stop_id = :stopY;

SELECT t FROM bus_timetabling.times_table t WHERE t.fromStop = :stopX AND t.toStop = :stopY;

SELECT s FROM TimesTable s WHERE s.fromStop = :fromStop AND s.toStop IN (:stopX, :stopY) ORDER BY s.departure ASC;

SELECT s FROM bus_timetabling.times_tables s WHERE s.fromStop = :stopX OR s.toStop IN (:stopX, :stopY) ORDER BY s.departure ASC;


SELECT * FROM route_stop_schedule;
SELECT * FROM stop WHERE route_stop_schedule_id = 1;
SELECT * FROM route WHERE route_stop_schedule_id = 1;

SELECT * FROM bus_timetabling.bus_route_manager;

SELECT * FROM bus_timetabling.bus WHERE bus_route_manager_id IS NOT NULL;

SELECT * FROM bus_timetabling.route WHERE bus_route_manager_id IS NOT NULL;


SELECT table_name
FROM information_schema.tables
WHERE table_schema = 'bus_timetabling';

SELECT * FROM bus_timetabling.routes WHERE bus_route_manager_id IS NOT NULL;

SELECT table_name
FROM information_schema.tables
WHERE table_schema = 'bus_timetabling';

select s1_0.route_stop_id,s1_0.stop_id,s1_0.stop_name from bus_timetabling.stops s1_0 where s1_0.route_stop_id=2

SELECT s1_0.route_stop_id, s1_0.stop_id, s1_0.stop_name
FROM bus_timetabling.stops s1_0
WHERE s1_0.route_stop_id = 1;

SELECT * FROM bus_timetabling.stops;

select b1_0.route_schedule_id,b1_0.bus_id,b1_0.bus_number,b1_0.status
from bus_timetabling.buses b1_0
where b1_0.route_schedule_id=1