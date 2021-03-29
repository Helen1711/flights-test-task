package ua.com.lena.flights.service.impl;

import org.springframework.stereotype.Service;
import ua.com.lena.flights.entities.Aircompany;
import ua.com.lena.flights.entities.Airplane;
import ua.com.lena.flights.entities.Flight;
import ua.com.lena.flights.entities.FlightStatus;
import ua.com.lena.flights.exceptions.EntityNotFoundException;
import ua.com.lena.flights.repository.FlightRepository;
import ua.com.lena.flights.service.AircompanyService;
import ua.com.lena.flights.service.AirplaneService;
import ua.com.lena.flights.service.FlightService;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository repository;
    private final AircompanyService aircompanyService;
    private final AirplaneService airplaneService;

    public FlightServiceImpl(FlightRepository repository, AircompanyService aircompanyService, AirplaneService airplaneService) {
        this.repository = repository;
        this.aircompanyService = aircompanyService;
        this.airplaneService = airplaneService;
    }

    @Override
    public List<Flight> getAllByStatusAndAircompanyName(FlightStatus status, String name) {
        aircompanyService.getByName(name)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Aircompany with name + %d not found", name))
                );
        return repository.findByStatusAndAircompanyName(status, name);
    }

    @Override
    public List<Flight> getAllByStatusAndStartedTime() {
        return repository.findByStatusAndStartedTime();
    }

    @Override
    public void save(long companyId, long airplaneId, Flight flight) {
        Aircompany aircompany = aircompanyService.getById(companyId)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Aircompany with id + %d not found", companyId))
                );
        Airplane airplane = airplaneService.getById(airplaneId)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Airplane with id + %d not found", airplaneId))
                );
        flight.setAircompany(aircompany);
        flight.setAirplane(airplane);
        repository.save(flight);
    }
}
