package com.airport.system.controller;

import com.airport.system.dto.TicketBookingDto;
import com.airport.system.entities.TicketBooking;
import com.airport.system.mapper.EntityToDtoMapper;
import com.airport.system.services.TicketBookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/bookings")
public class TicketBookingController {
    private final TicketBookingService ticketBookingService;
    private final EntityToDtoMapper entityMapper;

    @PostMapping
    public ResponseEntity<TicketBookingDto> createTicketBooking(@RequestBody TicketBookingDto ticketBookingDTO) {
        TicketBooking createdBooking = ticketBookingService.createTicketBooking(ticketBookingDTO);
        TicketBookingDto createdBookingDTO = entityMapper.ticketBookingToTicketBookingDTO(createdBooking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBookingDTO);
    }

    @GetMapping("/passenger/{id}")
    public ResponseEntity<List<TicketBookingDto>> getTicketBookingsByPassengerId(@PathVariable UUID id) {
        List<TicketBooking> ticketBookings = ticketBookingService.getTicketBookingsByPassengerId(id);
        return ResponseEntity.ok(
                ticketBookings.stream()
                        .map(entityMapper::ticketBookingToTicketBookingDTO)
                        .toList()
        );
    }

    @GetMapping("/flight/{id}")
    public ResponseEntity<List<TicketBookingDto>> getTicketBookingsByFlightId(@PathVariable UUID id) {
        List<TicketBooking> ticketBookings = ticketBookingService.getTicketBookingsByFlightId(id);
        return ResponseEntity.ok(
                ticketBookings.stream()
                        .map(entityMapper::ticketBookingToTicketBookingDTO)
                        .toList()
        );
    }
}
