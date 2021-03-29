package ua.com.lena.flights.service.impl;

import org.springframework.stereotype.Service;
import ua.com.lena.flights.entities.Flight;
import ua.com.lena.flights.entities.FlightStatus;
import ua.com.lena.flights.exceptions.EntityNotFoundException;
import ua.com.lena.flights.repository.FlightRepository;
import ua.com.lena.flights.service.AircompanyService;
import ua.com.lena.flights.service.FlightService;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository repository;
    private final AircompanyService service;

    public FlightServiceImpl(FlightRepository repository, AircompanyService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public List<Flight> getAllByStatusAndAircompanyName(FlightStatus status, String name) {
        service.getByName(name)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Aircompany with name + %d not found", name))
                );
        return repository.findByStatusAndAircompanyName(status, name);
    }
}
