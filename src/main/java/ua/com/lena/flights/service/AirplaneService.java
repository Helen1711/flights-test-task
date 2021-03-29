package ua.com.lena.flights.service;

import ua.com.lena.flights.entities.Airplane;

import java.util.Optional;

public interface AirplaneService {
    Airplane changeAircompany(long airplaneId, long aircompanyId);

    Optional<Airplane> getById(long id);

    void save(long companyId, Airplane airplane);

    Optional<Airplane> getBySerialNumber(String serialNumber);
}
