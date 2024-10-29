SELECT * FROM bus_timetabling.times_tables
WHERE to_stop_id = 1 AND arrival > '07:50'
ORDER BY arrival ASC
    LIMIT 3;
