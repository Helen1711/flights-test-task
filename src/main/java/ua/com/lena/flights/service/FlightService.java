package ua.com.lena.flights.service;

import ua.com.lena.flights.entities.Airplane;
import ua.com.lena.flights.entities.Flight;
import ua.com.lena.flights.entities.FlightStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<Flight> getAllByStatusAndAircompanyName(FlightStatus status, String name);

    List<Flight> getAllByStatusAndStartedTime(FlightStatus status, LocalDateTime time);

    Flight save(long companyId, long airplaneId, Flight flight);

    Flight getById(long id);

    void checkFlightDistance(Flight flight, Airplane airplane);

    void changeFlightStatus(long id, FlightStatus status);

    List<Flight> getAllWhereEstimatedTimeBiggerThanActual();
}
