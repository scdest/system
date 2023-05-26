package com.airport.system.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "number_of_seats_total")
    private int numberOfSeatsTotal;

    @Column(name = "number_of_seats_reserved")
    private int numberOfSeatsReserved;

    @Column(name = "from_location")
    private String from;

    @Column(name = "to_location")
    private String to;

    @Column(name = "datetime")
    private LocalDateTime datetime;
}
