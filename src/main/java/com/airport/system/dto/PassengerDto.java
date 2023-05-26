package com.airport.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
}
