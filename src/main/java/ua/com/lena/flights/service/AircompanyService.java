package ua.com.lena.flights.service;

import ua.com.lena.flights.entities.Aircompany;

import java.util.List;

public interface AircompanyService {
    Aircompany save(Aircompany aircompany);

    List<Aircompany> getAll();

    Aircompany update(long id, Aircompany aircompany);

    int remove(long id);

    void checkIfPresentByName(String name);

    Aircompany getById(long id);
}
