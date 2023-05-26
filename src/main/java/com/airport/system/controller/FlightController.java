package com.airport.system.controller;

import com.airport.system.dto.FlightDto;
import com.airport.system.entities.Flight;
import com.airport.system.mapper.EntityToDtoMapper;
import com.airport.system.services.FlightService;
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
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;
    private final EntityToDtoMapper entityMapper;

    @PostMapping
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDTO) {
        Flight savedFlight = flightService.saveFlight(flightDTO);
        FlightDto savedFlightDTO = entityMapper.flightToFlightDTO(savedFlight);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFlightDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable UUID id) {
        Flight flight = flightService.getFlightById(id);
        FlightDto flightDTO = entityMapper.flightToFlightDTO(flight);
        return ResponseEntity.ok(flightDTO);
    }

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights.stream()
                .map(entityMapper::flightToFlightDTO)
                .toList()
        );
    }
}
