package ua.com.lena.flights.service;

import ua.com.lena.flights.entities.Aircompany;

import java.util.List;
import java.util.Optional;

public interface AircompanyService {
    Aircompany save(Aircompany aircompany);

    List<Aircompany> getAll();

    Optional<Aircompany> getById(long id);

    Aircompany update(long id, Aircompany aircompany);

    int remove(long id);

    Optional<Aircompany> getByName(String name);
}
