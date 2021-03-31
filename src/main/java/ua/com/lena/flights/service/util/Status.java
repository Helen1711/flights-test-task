package ua.com.lena.flights.service.util;

import ua.com.lena.flights.entities.Flight;

public interface Status {
    Flight changeStatus(Flight flight);
}
