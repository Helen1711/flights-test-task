package ua.com.lena.flights.service;

import ua.com.lena.flights.entities.Flight;
import ua.com.lena.flights.entities.FlightStatus;

import java.util.List;

public interface FlightService {
    List<Flight> getAllByStatusAndAircompanyName(FlightStatus status, String name);

    List<Flight> getAllByStatusAndStartedTime();

    void save(long companyId, long airplaneId, Flight flight);
}
