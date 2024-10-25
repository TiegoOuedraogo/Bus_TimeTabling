//package com.example.bus_timetabling.controller;
//import com.example.bus_timetabling.dto.StopDto;
//import com.example.bus_timetabling.entities.Stop;
//import com.example.bus_timetabling.service.StopService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/stops")
//public class StopController {

//    private final StopService stopService;
//
//    public StopController(StopService stopService) {
//        this.stopService = stopService;
//    }
//
//    @GetMapping("")
//    public List<StopDto> findStops() {
//        return stopService.findAllStops();
//    }
//
//    @GetMapping("/{id}")
//    public StopDto findStopDetail(@PathVariable Long id) {
//        return stopService.findStopById(id);
//    }
//
//    @PostMapping(produces = "application/json")
//    public ResponseEntity<HttpStatus> createStop(@RequestBody StopDto request ) {
////        StopDto stopDto = new StopDto();
////        stopDto.setId(request.getId());
////        stopDto.setStopName(request.getStopName());
////        stopDto.setOrderInRoute(request.getOrderInRoute());
////        stopDto.setRoute(request.getRoute());
////        stopDto.setArrivalTimesTables(request.getArrivalTimesTables());
////        stopDto.setDepartureTimesTables(request.getDepartureTimesTables());
//        stopService.createStop(request);
//        return ResponseEntity.ok(HttpStatus.OK);
//    }
//
////    @PutMapping("/{id}")
////    public ResponseEntity<StopResponseDto> updateStop(@PathVariable long id, @RequestBody StopRequestDto request ) {
////        StopDto stopDto = new StopDto();
////        stopDto.setStopName(request.getStopName());
////        stopDto.setRoute(request.getRoute());
////        stopDto.setTimesTables(request.getTimesTables());
////
//////        return ResponseEntity.ok(stopService.createStop(stopDto));
//////
//////    }
//}
