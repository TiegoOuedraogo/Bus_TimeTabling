package com.example.bus_timetabling.dto;

import com.example.bus_timetabling.entities.BusRouteManager;
import com.example.bus_timetabling.entities.Stop;
import com.example.bus_timetabling.entities.TimesTable;
import com.example.bus_timetabling.enums.ServiceStatus;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusDto {
    private Long id;
    private String busNumber;
    private ServiceStatus status;
    private Stop toStop;
    private Stop fromStop;
    private BusRouteManager bus_Route;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }

    public Stop getToStop() {
        return toStop;
    }

    public void setToStop(Stop toStop) {
        this.toStop = toStop;
    }

    public Stop getFromStop() {
        return fromStop;
    }

    public void setFromStop(Stop fromStop) {
        this.fromStop = fromStop;
    }

    public BusRouteManager getBus_Route() {
        return bus_Route;
    }

    public void setBus_Route(BusRouteManager bus_Route) {
        this.bus_Route = bus_Route;
    }
}