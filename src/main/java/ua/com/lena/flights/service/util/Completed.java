package ua.com.lena.flights.service.util;

import ua.com.lena.flights.entities.Flight;
import ua.com.lena.flights.entities.FlightStatus;

import java.time.LocalDateTime;

public class Completed  implements Status{
    @Override
    public Flight changeStatus(Flight flight) {
        flight.setStatus(FlightStatus.COMPLETED);
        flight.setEndedAt(LocalDateTime.now());
        return flight;
    }
}
