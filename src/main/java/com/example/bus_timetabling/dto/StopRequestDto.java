package com.example.bus_timetabling.dto;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class StopRequestDto{
    private String stopName;
//    private List<TimesTableRequestDto> timesTables;
}
