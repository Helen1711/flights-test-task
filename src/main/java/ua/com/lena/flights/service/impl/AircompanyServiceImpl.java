package ua.com.lena.flights.service.impl;

import org.springframework.stereotype.Service;
import ua.com.lena.flights.entities.Aircompany;
import ua.com.lena.flights.repository.AircompanyRepository;
import ua.com.lena.flights.service.AircompanyService;

import java.util.List;
import java.util.Optional;

@Service
public class AircompanyServiceImpl implements AircompanyService {
    private final AircompanyRepository repository;

    public AircompanyServiceImpl(AircompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Aircompany aircompany) {
        repository.save(aircompany);
    }

    @Override
    public List<Aircompany> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Aircompany> getById(long id) {
        return repository.findById(id);
    }

    @Override
    public Aircompany update(long id, Aircompany aircompany) {
        aircompany.setId(id);
        return repository.save(aircompany);
    }

    @Override
    public int remove(long id) {
        return repository.drop(id);
    }

    @Override
    public Optional<Aircompany> getByName(String name) {
        return repository.findByName(name);
    }
}
