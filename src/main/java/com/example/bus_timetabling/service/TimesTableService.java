//package com.example.bus_timetabling.service;
//
//import com.example.bus_timetabling.dto.TimesTableDto;
//import com.example.bus_timetabling.dto.TimesTableRequestDto;
//import com.example.bus_timetabling.dto.TimesTableResponseDto;
//import com.example.bus_timetabling.entities.TimesTable;
//import com.example.bus_timetabling.entities.Bus;
//import com.example.bus_timetabling.entities.Stop;
//import com.example.bus_timetabling.mapper.TimesTableMapper;
//import com.example.bus_timetabling.repository.TimesTableRepository;
//import com.example.bus_timetabling.repository.BusRepository;
//import com.example.bus_timetabling.repository.StopRepository;
//import org.springframework.stereotype.ServiceStatus;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@ServiceStatus
//@Transactional
//public class TimesTableService {
//
//    private final TimesTableRepository timesTableRepository;
//    private final BusRepository busRepository;
//    private final StopRepository stopRepository;
//    private final TimesTableMapper timesTableMapper;
//
//    public TimesTableService(TimesTableRepository timesTableRepository, BusRepository busRepository,
//                             StopRepository stopRepository, TimesTableMapper timesTableMapper) {
//        this.timesTableRepository = timesTableRepository;
//        this.busRepository = busRepository;
//        this.stopRepository = stopRepository;
//        this.timesTableMapper = timesTableMapper;
//    }
//
//    public TimesTableResponseDto createTimesTable(TimesTableRequestDto timesTableRequestDto) {
//        TimesTable timesTable = timesTableMapper.toTimesTable(timesTableRequestDto);
//        Bus bus = busRepository.findById(timesTableRequestDto.getBus().getId())
//                .orElseThrow(() -> new RuntimeException("Bus not found"));
//        Stop fromStop = stopRepository.findById(timesTableRequestDto.getFromStopId())
//                .orElseThrow(() -> new RuntimeException("From Stop not found"));
//        Stop toStop = stopRepository.findById(timesTableRequestDto.getToStopId())
//                .orElseThrow(() -> new RuntimeException("To Stop not found"));
//
//        timesTable.setBus(bus);
//        timesTable.setFromStopId(fromStop.getId());
//        timesTable.setToStopId(toStop.getId());
//
//        TimesTable savedTimesTable = timesTableRepository.save(timesTable);
//        return timesTableMapper.toTimesTableResponseDto(savedTimesTable);
//    }
//
//    public TimesTableResponseDto getTimesTableById(Long id) {
//        TimesTable timesTable = timesTableRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("TimesTable not found"));
//        return timesTableMapper.toTimesTableResponseDto(timesTable);
//    }
//
//    public List<TimesTableResponseDto> getAllTimesTables() {
//        return timesTableRepository.findAll().stream()
//                .map(timesTableMapper::toTimesTableResponseDto)
//                .collect(Collectors.toList());
//    }
//
//    public TimesTableResponseDto updateTimesTable(Long id, TimesTableRequestDto timesTableRequestDto) {
//        TimesTable timesTable = timesTableRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("TimesTable not found"));
//
//        timesTable.setDeparture(timesTableRequestDto.getDeparture());
//        timesTable.setArrival(timesTableRequestDto.getArrival());
////        timesTable.setSegmentDistance(timesTableRequestDto.getSegmentDistance());
//
//        Bus bus = busRepository.findById(timesTableRequestDto.getBus().getId())
//                .orElseThrow(() -> new RuntimeException("Bus not found"));
//        Stop fromStop = stopRepository.findById(timesTableRequestDto.getFromStopId())
//                .orElseThrow(() -> new RuntimeException("From Stop not found"));
//        Stop toStop = stopRepository.findById(timesTableRequestDto.getToStopId())
//                .orElseThrow(() -> new RuntimeException("To Stop not found"));
//
//        timesTable.setBus(bus);
//        timesTable.setFromStopId(fromStop.getId());
//        timesTable.setToStopId(toStop.getId());
//
//        TimesTable updatedTimesTable = timesTableRepository.save(timesTable);
//        return timesTableMapper.toTimesTableResponseDto(updatedTimesTable);
//    }
//
//    public void deleteTimesTable(Long id) {
//        if (!timesTableRepository.existsById(id)) {
//            throw new RuntimeException("TimesTable not found");
//        }
//        timesTableRepository.deleteById(id);
//    }
//}