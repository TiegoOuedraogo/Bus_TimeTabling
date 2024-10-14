package com.example.bus_timetabling.controller;

import com.example.bus_timetabling.entities.Stop;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/stops")
public class StopController {

    @GetMapping("")
    //turn into DTO object response later
    public String getStops() {
        return "These are the stops";
    }

    @GetMapping("/{id}")
    //turn into DTO object response later
    public Long getStopDetail(@PathVariable Long id) {
        return id;
    }

    @PostMapping(produces = "application/json")
    public String createStop(@RequestBody Stop stop) {
        return "Your stop has been created";
    }
}
