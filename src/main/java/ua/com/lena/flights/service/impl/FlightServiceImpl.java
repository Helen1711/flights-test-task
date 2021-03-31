package ua.com.lena.flights.service.impl;

import org.springframework.stereotype.Service;
import ua.com.lena.flights.entities.Airplane;
import ua.com.lena.flights.entities.Flight;
import ua.com.lena.flights.entities.FlightStatus;
import ua.com.lena.flights.exceptions.EntityNotFoundException;
import ua.com.lena.flights.exceptions.FlightDistanceException;
import ua.com.lena.flights.repository.FlightRepository;
import ua.com.lena.flights.service.AircompanyService;
import ua.com.lena.flights.service.AirplaneService;
import ua.com.lena.flights.service.FlightService;
import ua.com.lena.flights.service.util.StatusFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public List<Flight> getAllByStatusAndStartedTime(FlightStatus status, LocalDateTime time) {
        return repository.findByStatusAndStartedTime(status, time);
    }

    @Override
    public Flight save(long companyId, long airplaneId, Flight flight) {
        var aircompany = aircompanyService.getById(companyId)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Aircompany with id + %d not found", companyId))
                );
        var airplane = airplaneService.getById(airplaneId)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Airplane with id + %d not found", airplaneId))
                );
        checkFlightDistance(flight, airplane);
        flight.setAircompany(aircompany);
        flight.setAirplane(airplane);
        return repository.save(flight);
    }

    @Override
    public void changeFlightStatus(long id, FlightStatus status) {
        var flight = repository.getOne(id);
        StatusFactory.getStatus(status)
                .changeStatus(flight);
        repository.save(flight);
    }

    @Override
    public Optional<Flight> getById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Flight> getAllWhereEstimatedTimeBiggerThanActual() {
        return repository.findAllWhereEstimatedTimeBiggerThanActual();
    }

    private void checkFlightDistance(Flight flight, Airplane airplane){
        if(flight.getDistance() > airplane.getFlightDistance()){
            throw new FlightDistanceException(String.format("Distance %s is too long", flight.getDistance()));
        }
    }
}
