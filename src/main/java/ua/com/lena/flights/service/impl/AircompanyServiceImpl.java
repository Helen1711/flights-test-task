package ua.com.lena.flights.service.impl;

import org.springframework.stereotype.Service;
import ua.com.lena.flights.entities.Aircompany;
import ua.com.lena.flights.exceptions.AircompanyDuplicateNameException;
import ua.com.lena.flights.exceptions.EntityNotFoundException;
import ua.com.lena.flights.exceptions.messages.ExceptionMessage;
import ua.com.lena.flights.repository.AircompanyRepository;
import ua.com.lena.flights.service.AircompanyService;

import java.util.List;

@Service
public class AircompanyServiceImpl implements AircompanyService {
    private final AircompanyRepository repository;

    public AircompanyServiceImpl(AircompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Aircompany save(Aircompany aircompany) {
        checkIfPresentByName(aircompany.getName());
        return repository.save(aircompany);
    }

    @Override
    public List<Aircompany> getAll() {
        return repository.findAll();
    }

    @Override
    public Aircompany update(long id, Aircompany aircompany) {
        aircompany.setId(id);
        return repository.save(aircompany);
    }

    @Override
    public int remove(long id) {
        getById(id);
        return repository.drop(id);
    }

    @Override
    public void checkIfPresentByName(String name) {
        repository.findByName(name).ifPresent(a -> {
            throw new AircompanyDuplicateNameException(ExceptionMessage.AIRCOMPANY_WITH_NAME_EXISTS + name);
        });
    }

    @Override
    public Aircompany getById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessage.AIRCOMPANY_BY_ID_NOT_FOUND + id));
    }
}
