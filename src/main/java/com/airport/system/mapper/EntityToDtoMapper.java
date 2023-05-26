package com.airport.system.mapper;

import com.airport.system.dto.FlightDto;
import com.airport.system.dto.PassengerDto;
import com.airport.system.dto.TicketBookingDto;
import com.airport.system.entities.Flight;
import com.airport.system.entities.Passenger;
import com.airport.system.entities.TicketBooking;
import org.springframework.stereotype.Component;

@Component
public class EntityToDtoMapper {
    public FlightDto flightToFlightDTO(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId());
        flightDto.setNumberOfSeatsTotal(flight.getNumberOfSeatsTotal());
        flightDto.setFrom(flight.getFrom());
        flightDto.setTo(flight.getTo());
        flightDto.setDatetime(flight.getDatetime());
        return flightDto;
    }

    public Flight flightDTOToFlight(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setId(flightDto.getId());
        flight.setNumberOfSeatsTotal(flightDto.getNumberOfSeatsTotal());
        flight.setFrom(flightDto.getFrom());
        flight.setTo(flightDto.getTo());
        flight.setDatetime(flightDto.getDatetime());
        return flight;
    }

    public PassengerDto passengerToPassengerDTO(Passenger passenger) {
        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setId(passenger.getId());
        passengerDto.setFirstName(passenger.getFirstName());
        passengerDto.setLastName(passenger.getLastName());
        passengerDto.setAge(passenger.getAge());
        return passengerDto;
    }

    public Passenger passengerDTOToPassenger(PassengerDto passengerDto) {
        Passenger passenger = new Passenger();
        passenger.setId(passengerDto.getId());
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setAge(passengerDto.getAge());
        return passenger;
    }

    public TicketBookingDto ticketBookingToTicketBookingDTO(TicketBooking ticketBooking) {
        TicketBookingDto ticketBookingDto = new TicketBookingDto();
        ticketBookingDto.setId(ticketBooking.getId());
        ticketBookingDto.setPassengerId(ticketBooking.getPassenger().getId());
        ticketBookingDto.setFlightId(ticketBooking.getFlight().getId());
        ticketBookingDto.setBookedAt(ticketBooking.getBookedAt());
        return ticketBookingDto;
    }

    public TicketBooking ticketBookingDTOToTicketBooking(TicketBookingDto ticketBookingDto) {
        TicketBooking ticketBooking = new TicketBooking();
        ticketBooking.setId(ticketBookingDto.getId());
        Passenger passenger = new Passenger();
        passenger.setId(ticketBookingDto.getPassengerId());
        ticketBooking.setPassenger(passenger);
        Flight flight = new Flight();
        flight.setId(ticketBookingDto.getFlightId());
        ticketBooking.setFlight(flight);
        ticketBooking.setBookedAt(ticketBookingDto.getBookedAt());
        return ticketBooking;
    }
}
