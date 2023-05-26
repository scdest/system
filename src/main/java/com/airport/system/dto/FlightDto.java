package com.airport.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private UUID id;
    private int numberOfSeatsTotal;
    private String from;
    private String to;
    private LocalDateTime datetime;
}

