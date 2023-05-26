package com.airport.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketBookingDto {
    private UUID id;
    private UUID passengerId;
    private UUID flightId;
    private LocalDateTime bookedAt;
}
