package ua.com.lena.flights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.com.lena.flights.entities.Flight;
import ua.com.lena.flights.entities.FlightStatus;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByStatusAndAircompanyName(FlightStatus status, String name);

    @Query(value = "select * from flight where status = 'ACTIVE' and delay_started_at < now() - interval 1 day",
            nativeQuery = true)
    List<Flight> findByStatusAndStartedTime();
}
