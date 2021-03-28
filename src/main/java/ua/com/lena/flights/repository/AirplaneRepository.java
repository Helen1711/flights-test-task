package ua.com.lena.flights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.lena.flights.entities.Airplane;

import java.util.Optional;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    Optional<Airplane> findByFactorySerialNumber(String serialNumber);
}
