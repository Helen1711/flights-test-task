package ua.com.lena.flights.service;

import ua.com.lena.flights.entities.Flight;
import ua.com.lena.flights.entities.FlightStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<Flight> getAllByStatusAndAircompanyName(FlightStatus status, String name);

    List<Flight> getAllByStatusAndStartedTime(FlightStatus status, LocalDateTime time);

    Flight save(long companyId, long airplaneId, Flight flight);

    void changeFlightStatus(long id, FlightStatus status);

    Optional<Flight> getById(long id);
}
