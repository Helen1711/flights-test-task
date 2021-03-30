package ua.com.lena.flights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.lena.flights.entities.Flight;
import ua.com.lena.flights.entities.FlightStatus;
import ua.com.lena.flights.repository.custom.FlightRepositoryCustom;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long>, FlightRepositoryCustom {
    List<Flight> findByStatusAndAircompanyName(FlightStatus status, String name);
}
