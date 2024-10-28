select b1_0.bus_id,b1_0.bus_number,brm1_0.bus_route_id,b1_0.status,t1_0.times_table_id,t1_0.arrival,t1_0.departure,fs1_0.stop_id,rss1_0.route_stop_id,r1_0.route_id,brm2_0.bus_route_id,r1_0.distance,r1_0.route_name,rss2_0.route_stop_id,rss2_0.route_id,s1_0.stop_id,s1_0.route_stop_id,s1_0.stop_name,rss2_0.stop_num,s2_0.stop_id,s2_0.route_stop_id,s2_0.stop_name,rss1_0.stop_num,fs1_0.stop_name,ts1_0.stop_id,rss5_0.route_stop_id,r3_0.route_id,brm3_0.bus_route_id,r3_0.distance,r3_0.route_name,rss6_0.route_stop_id,rss6_0.route_id,s3_0.stop_id,s3_0.route_stop_id,s3_0.stop_name,rss6_0.stop_num,s4_0.stop_id,s4_0.route_stop_id,s4_0.stop_name,rss5_0.stop_num,ts1_0.stop_name from bus_timetabling.buses b1_0 left join bus_timetabling.bus_route_manager brm1_0 on brm1_0.bus_route_id=b1_0.route_schedule_id left join bus_timetabling.times_tables t1_0 on t1_0.times_table_id=b1_0.times_table_id left join bus_timetabling.stops fs1_0 on fs1_0.stop_id=t1_0.from_stop_id left join bus_timetabling.route_stop_schedule rss1_0 on rss1_0.route_stop_id=fs1_0.route_stop_id left join bus_timetabling.routes r1_0 on r1_0.route_id=rss1_0.route_id left join bus_timetabling.bus_route_manager brm2_0 on brm2_0.bus_route_id=r1_0.bus_route_id left join bus_timetabling.route_stop_schedule rss2_0 on rss2_0.route_stop_id=r1_0.route_stop_id left join bus_timetabling.stops s1_0 on s1_0.stop_id=rss2_0.stop_id left join bus_timetabling.stops s2_0 on s2_0.stop_id=rss1_0.stop_id left join bus_timetabling.stops ts1_0 on ts1_0.stop_id=t1_0.to_stop_id left join bus_timetabling.route_stop_schedule rss5_0 on rss5_0.route_stop_id=ts1_0.route_stop_id left join bus_timetabling.routes r3_0 on r3_0.route_id=rss5_0.route_id left join bus_timetabling.bus_route_manager brm3_0 on brm3_0.bus_route_id=r3_0.bus_route_id left join bus_timetabling.route_stop_schedule rss6_0 on rss6_0.route_stop_id=r3_0.route_stop_id left join bus_timetabling.stops s3_0 on s3_0.stop_id=rss6_0.stop_id
left join bus_timetabling.stops s4_0
on s4_0.stop_id=rss5_0.stop_id
where b1_0.bus_id=?