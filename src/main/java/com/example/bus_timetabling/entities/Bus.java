package com.example.bus_timetabling.entities;

import com.example.bus_timetabling.enums.ServiceStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buses",  schema = "bus_timetabling")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long id;

    @Column(name = "bus_number")
    private String busNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ServiceStatus status;

//    // Relationships
//    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<TimesTable> timesTables = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "times_table_id")
    private TimesTable timestables;
//    @ManyToOne
//    @JoinColumn(name = "to_stop_id") //defaults to primary key of Stop
//    private Stop toStop;
//
//    @ManyToOne
//    @JoinColumn(name = "from_stop_id") //defaults to primary key of Stop
//    private Stop fromStop;

    @ManyToOne
    @JoinColumn(name = "route_schedule_id") //defaults to primary key of BusRouteManager
    private BusRouteManager busRouteManager;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getBusNumber() {
//        return busNumber;
//    }
//
//    public void setBusNumber(String busNumber) {
//        this.busNumber = busNumber;
//    }
//
//    public ServiceStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(ServiceStatus status) {
//        this.status = status;
//    }
//
//    public List<TimesTable> getTimesTables() {
//        return timesTables;
//    }
//
//    public void setTimesTables(List<TimesTable> timesTables) {
//        this.timesTables = timesTables;
//    }
//
//    public Stop getToStop() {
//        return toStop;
//    }
//
//    public void setToStop(Stop toStop) {
//        this.toStop = toStop;
//    }
//
//    public Stop getFromStop() {
//        return fromStop;
//    }
//
//    public void setFromStop(Stop fromStop) {
//        this.fromStop = fromStop;
//    }
//
//    public BusRouteManager getBusRouteManager() {
//        return busRouteManager;
//    }
//
//    public void setBusRouteManager(BusRouteManager busRouteManager) {
//        this.busRouteManager = busRouteManager;
//    }
}
