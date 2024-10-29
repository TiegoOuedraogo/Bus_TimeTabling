package com.example.bus_timetabling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RouteStopScheduleNotFoundException extends RuntimeException {
    public RouteStopScheduleNotFoundException(Long route_stop_id){super ("Route Stop Schedule with" + route_stop_id + "was not found");}
}
