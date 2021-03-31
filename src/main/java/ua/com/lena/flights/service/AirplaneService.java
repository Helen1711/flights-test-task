package ua.com.lena.flights.service;

import ua.com.lena.flights.entities.Airplane;

public interface AirplaneService {
    Airplane changeAircompany(long airplaneId, long aircompanyId);

    Airplane save(long companyId, Airplane airplane);

    void checkBySerialNumber(String serialNumber);

    Airplane getById(long id);
}
