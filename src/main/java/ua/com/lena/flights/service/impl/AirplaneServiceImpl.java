package ua.com.lena.flights.service.impl;

import org.springframework.stereotype.Service;
import ua.com.lena.flights.entities.Aircompany;
import ua.com.lena.flights.entities.Airplane;
import ua.com.lena.flights.exceptions.EntityNotFoundException;
import ua.com.lena.flights.repository.AirplaneRepository;
import ua.com.lena.flights.service.AircompanyService;
import ua.com.lena.flights.service.AirplaneService;

import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository repository;
    private final AircompanyService aircompanyService;

    public AirplaneServiceImpl(AirplaneRepository repository, AircompanyService aircompanyService) {
        this.repository = repository;
        this.aircompanyService = aircompanyService;
    }

    @Override
    public Airplane changeAircompany(long airplaneId, long companyId) {
        var airplane = getById(airplaneId)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Airplane with id + %d not found", airplaneId))
                );

        var aircompany = aircompanyService.getById(companyId)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Aircompany with id + %d not found", companyId))
                );
        airplane.setAircompany(aircompany);
        return repository.save(airplane);
    }

    @Override
    public Optional<Airplane> getById(long id) {
        return repository.findById(id);
    }

    @Override
    public void save(long companyId, Airplane airplane) {
        var aircompany = getAircompanyById(companyId);
        airplane.setAircompany(aircompany);
        repository.save(airplane);
    }

    @Override
    public Optional<Airplane> getBySerialNumber(String serialNumber) {
        return repository.findByFactorySerialNumber(serialNumber);
    }

    private Aircompany getAircompanyById(long id) {
        return aircompanyService.getById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Aircompany with id + %d not found", id))
        );
    }
}
