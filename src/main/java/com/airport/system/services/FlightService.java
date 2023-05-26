package com.airport.system.services;

import com.airport.system.dto.FlightDto;
import com.airport.system.entities.Flight;
import com.airport.system.mapper.EntityToDtoMapper;
import com.airport.system.repositories.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final EntityToDtoMapper entityMapper;

    public Flight saveFlight(FlightDto flightDTO) {
        Flight flight = entityMapper.flightDTOToFlight(flightDTO);
        return flightRepository.save(flight);
    }

    public Flight getFlightById(UUID id) {
        return flightRepository.findById(id).orElseThrow();
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
