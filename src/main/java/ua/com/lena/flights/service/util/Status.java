package ua.com.lena.flights.service.util;

import ua.com.lena.flights.entities.Flight;

@FunctionalInterface
public interface Status {
    Flight changeStatus(Flight flight);
}
