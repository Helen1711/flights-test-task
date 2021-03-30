package ua.com.lena.flights.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Flight extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    @NotNull
    private FlightStatus status = FlightStatus.PENDING;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircompany_id")
    @NotNull
    @JsonIgnore
    private Aircompany aircompany;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id")
    @NotNull
    @JsonIgnore
    private Airplane airplane;
    @Column(name = "departure_country")
    @NotNull
    private String departureCountry;
    @Column(name = "destination_country")
    @NotNull
    private String destinationCountry;
    @Positive
    private double distance;
    @Column(name = "estimated_flight_time")
    @NotNull
    private LocalTime estimatedFlightTime;
    @Column(name = "ended_at")
    private LocalDateTime endedAt;
    @Column(name = "delay_started_at")
    private LocalDateTime delayStartedAt;

    public Flight() {
    }

    public Flight(LocalDate createdAt, @NotNull Aircompany aircompany, @NotNull Airplane airplane,
                  @NotNull String departureCountry, @NotNull String destinationCountry,
                  @Positive double distance, @NotNull LocalTime estimatedFlightTime) {
        super(createdAt);
        this.aircompany = aircompany;
        this.airplane = airplane;
        this.departureCountry = departureCountry;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
        this.estimatedFlightTime = estimatedFlightTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public Aircompany getAircompany() {
        return aircompany;
    }

    public void setAircompany(Aircompany aircompany) {
        this.aircompany = aircompany;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public LocalTime getEstimatedFlightTime() {
        return estimatedFlightTime;
    }

    public void setEstimatedFlightTime(LocalTime estimatedFlightTime) {
        this.estimatedFlightTime = estimatedFlightTime;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public LocalDateTime getDelayStartedAt() {
        return delayStartedAt;
    }

    public void setDelayStartedAt(LocalDateTime delayStartedAt) {
        this.delayStartedAt = delayStartedAt;
    }
}
