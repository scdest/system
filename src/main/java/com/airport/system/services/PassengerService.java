package com.airport.system.services;

import com.airport.system.dto.PassengerDto;
import com.airport.system.entities.Passenger;
import com.airport.system.mapper.EntityToDtoMapper;
import com.airport.system.repositories.PassengerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;
    private final EntityToDtoMapper entityMapper;


    public Passenger savePassenger(PassengerDto passengerDTO) {
        Passenger passenger = entityMapper.passengerDTOToPassenger(passengerDTO);
        return passengerRepository.save(passenger);
    }

    public Passenger getPassengerById(UUID id) {
        return passengerRepository.findById(id).orElseThrow();
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }
}
