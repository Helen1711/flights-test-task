package ua.com.lena.flights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.lena.flights.entities.Aircompany;
import ua.com.lena.flights.repository.custom.AircompanyRepositoryCustom;

import java.util.Optional;

public interface AircompanyRepository extends JpaRepository<Aircompany, Long>, AircompanyRepositoryCustom {
    Optional<Aircompany> findByName(String name);
}
