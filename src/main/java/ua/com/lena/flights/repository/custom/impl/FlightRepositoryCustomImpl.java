package ua.com.lena.flights.repository.custom.impl;

import org.springframework.stereotype.Repository;
import ua.com.lena.flights.entities.Flight;
import ua.com.lena.flights.entities.FlightStatus;
import ua.com.lena.flights.repository.custom.FlightRepositoryCustom;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class FlightRepositoryCustomImpl implements FlightRepositoryCustom {
    private final EntityManager entityManager;

    public FlightRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Flight> findByStatusAndStartedTime(FlightStatus status, LocalDateTime time) {

        return entityManager.createQuery(
                "select f from Flight f where f.status = :status and f.delay_started_at < :time"
        )
                .setParameter("status", status)
                .setParameter("time", time)
                .getResultList();
    }
}
