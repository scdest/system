package com.airport.system.services;

import com.airport.system.dto.TicketBookingDto;
import com.airport.system.entities.Flight;
import com.airport.system.entities.Passenger;
import com.airport.system.entities.TicketBooking;
import com.airport.system.exceptions.NotAvailableException;
import com.airport.system.exceptions.NotFoundException;
import com.airport.system.mapper.EntityToDtoMapper;
import com.airport.system.repositories.FlightRepository;
import com.airport.system.repositories.PassengerRepository;
import com.airport.system.repositories.TicketBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketBookingService {

    private final TicketBookingRepository ticketBookingRepository;
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final EntityToDtoMapper entityMapper;

    public TicketBooking createTicketBooking(TicketBookingDto ticketBookingDTO) {
        Flight flight = flightRepository.findById(ticketBookingDTO.getFlightId())
                .orElseThrow(() -> new NotFoundException("Flight not found with ID: " + ticketBookingDTO.getFlightId()));

        Passenger passenger = passengerRepository.findById(ticketBookingDTO.getPassengerId())
                .orElseThrow(() -> new NotFoundException("Passenger not found with ID: " + ticketBookingDTO.getPassengerId()));

        if (flight.getNumberOfSeatsReserved() >= flight.getNumberOfSeatsTotal()) {
            throw new NotAvailableException("No available seats on the flight");
        }

        TicketBooking ticketBooking = entityMapper.ticketBookingDTOToTicketBooking(ticketBookingDTO);
        ticketBooking.setFlight(flight);
        ticketBooking.setPassenger(passenger);
        ticketBooking.setBookedAt(LocalDateTime.now());

        flight.setNumberOfSeatsReserved(flight.getNumberOfSeatsReserved() + 1);
        flightRepository.save(flight);

        return ticketBookingRepository.save(ticketBooking);
    }

    public List<TicketBooking> getTicketBookingsByPassengerId(UUID passengerId) {
        return ticketBookingRepository.findByPassengerId(passengerId);
    }

    public List<TicketBooking> getTicketBookingsByFlightId(UUID flightId) {
        return ticketBookingRepository.findByFlightId(flightId);
    }
}
