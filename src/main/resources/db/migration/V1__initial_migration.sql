-- Create table: flights
CREATE TABLE flights (
  id UUID PRIMARY KEY,
  number_of_seats_total SMALLINT NOT NULL,
  number_of_seats_reserved SMALLINT NOT NULL DEFAULT 0,
  from_location VARCHAR NOT NULL,
  to_location VARCHAR NOT NULL,
  datetime TIMESTAMP NOT NULL
);

-- Create table: passengers
CREATE TABLE passengers (
  id UUID PRIMARY KEY,
  first_name VARCHAR NOT NULL,
  last_name VARCHAR NOT NULL,
  age SMALLINT NOT NULL
);

-- Create table: ticket_bookings
CREATE TABLE ticket_bookings (
  id UUID PRIMARY KEY,
  passenger_id UUID NOT NULL,
  flight_id UUID NOT NULL,
  booked_at TIMESTAMP NOT NULL,
  CONSTRAINT fk_passengers FOREIGN KEY (passenger_id) REFERENCES passengers (id),
  CONSTRAINT fk_flights FOREIGN KEY (flight_id) REFERENCES flights (id),
  CONSTRAINT unique_booking UNIQUE (passenger_id, flight_id)
);
