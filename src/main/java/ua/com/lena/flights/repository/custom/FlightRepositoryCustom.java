package ua.com.lena.flights.repository.custom;

import ua.com.lena.flights.entities.Flight;
import ua.com.lena.flights.entities.FlightStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepositoryCustom {
    List<Flight> findByStatusAndStartedTime(FlightStatus status, LocalDateTime time);

    List<Flight> findAllWhereEstimatedTimeBiggerThanActual();
}
