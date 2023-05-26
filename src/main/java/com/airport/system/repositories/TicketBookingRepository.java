package com.airport.system.repositories;

import com.airport.system.entities.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TicketBookingRepository extends JpaRepository<TicketBooking, UUID> {
    List<TicketBooking> findByFlightId(UUID flightId);

    List<TicketBooking> findByPassengerId(UUID passengerId);
}
