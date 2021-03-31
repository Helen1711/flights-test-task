package ua.com.lena.flights.service.impl;

import org.springframework.stereotype.Service;
import ua.com.lena.flights.entities.Airplane;
import ua.com.lena.flights.exceptions.AirplaneDuplicateSerialNumberException;
import ua.com.lena.flights.exceptions.EntityNotFoundException;
import ua.com.lena.flights.exceptions.messages.ExceptionMessage;
import ua.com.lena.flights.repository.AirplaneRepository;
import ua.com.lena.flights.service.AircompanyService;
import ua.com.lena.flights.service.AirplaneService;

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
        var airplane = getById(airplaneId);
        var aircompany = aircompanyService.getById(companyId);
        airplane.setAircompany(aircompany);
        return repository.save(airplane);
    }

    @Override
    public Airplane save(long companyId, Airplane airplane) {
        var aircompany = aircompanyService.getById(companyId);
        checkBySerialNumber(airplane.getFactorySerialNumber());
        airplane.setAircompany(aircompany);
        return repository.save(airplane);
    }

    @Override
    public void checkBySerialNumber(String serialNumber) {
        repository.findByFactorySerialNumber(serialNumber).ifPresent(a -> {
            throw new AirplaneDuplicateSerialNumberException(
                    ExceptionMessage.AIRPLANE_WITH_SERIAL_NUMBER_EXISTS + serialNumber
            );
        });
    }

    @Override
    public Airplane getById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessage.AIRPLANE_BY_ID_NOT_FOUND + id));
    }
}
