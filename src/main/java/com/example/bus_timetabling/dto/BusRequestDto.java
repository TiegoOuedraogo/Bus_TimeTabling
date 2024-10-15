package com.example.bus_timetabling.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
@ToString
@Getter
@Setter
@Builder
public class BusRequestDto {
    private String busNumber;
    private List<TimesTableDto> timesTables;
    private Service status;
}
