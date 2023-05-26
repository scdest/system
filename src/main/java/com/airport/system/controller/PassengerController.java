package com.airport.system.controller;

import com.airport.system.dto.PassengerDto;
import com.airport.system.entities.Passenger;
import com.airport.system.mapper.EntityToDtoMapper;
import com.airport.system.services.PassengerService;
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
@RequestMapping("/passengers")
public class PassengerController {
    private final PassengerService passengerService;
    private final EntityToDtoMapper entityMapper;

    @PostMapping
    public ResponseEntity<PassengerDto> createPassenger(@RequestBody PassengerDto passengerDTO) {
        Passenger savedPassenger = passengerService.savePassenger(passengerDTO);
        PassengerDto savedPassengerDTO = entityMapper.passengerToPassengerDTO(savedPassenger);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPassengerDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDto> getPassengerById(@PathVariable UUID id) {
        Passenger passenger = passengerService.getPassengerById(id);
        PassengerDto passengerDTO = entityMapper.passengerToPassengerDTO(passenger);
        return ResponseEntity.ok(passengerDTO);
    }

    @GetMapping
    public ResponseEntity<List<PassengerDto>> getAllPassengers() {
        List<Passenger> passengers = passengerService.getAllPassengers();
        return ResponseEntity.ok(
                passengers.stream()
                        .map(entityMapper::passengerToPassengerDTO)
                        .toList()
        );
    }
}
