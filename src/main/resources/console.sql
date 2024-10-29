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


SELECT t FROM bus_timetabling.times_tables t WHERE from_stop_id = :stopX AND to_stop_id = :stopY;

SELECT t FROM bus_timetabling.times_table t WHERE t.fromStop = :stopX AND t.toStop = :stopY;

SELECT s FROM TimesTable s WHERE s.fromStop = :fromStop AND s.toStop IN (:stopX, :stopY) ORDER BY s.departure ASC