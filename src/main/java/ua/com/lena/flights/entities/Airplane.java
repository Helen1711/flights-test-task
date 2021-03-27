package ua.com.lena.flights.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Airplane extends AbstractEntity {
    @Size(min = 3, max = 20)
    @NotNull
    private String name;
    @Column(name = "factory_serial_number", unique = true)
    @NotNull
    private String factorySerialNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircompany_id")
    private Aircompany aircompany;
    @Column(name = "number_of_flights")
    @NotNull
    private int numberOfFlights;
    @Column(name = "flight_distance")
    @NotNull
    private double flightDistance;
    @Column(name = "fuel_capacity")
    @NotNull
    private int fuelCapacity;
    @Enumerated(EnumType.STRING)
    @NotNull
    private AirplaneType type;

    public Airplane() {
    }

    public Airplane(LocalDate createdAt, @Size(min = 3, max = 20) @NotNull String name,
                    @NotNull String factorySerialNumber, Aircompany aircompany, @NotNull int numberOfFlights,
                    @NotNull double flightDistance, @NotNull int fuelCapacity, @NotNull AirplaneType type) {
        super(createdAt);
        this.name = name;
        this.factorySerialNumber = factorySerialNumber;
        this.aircompany = aircompany;
        this.numberOfFlights = numberOfFlights;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
    }

    public Airplane(@Size(min = 3, max = 20) @NotNull String name, @NotNull String factorySerialNumber,
                    Aircompany aircompany, @NotNull int numberOfFlights, @NotNull double flightDistance,
                    @NotNull int fuelCapacity, @NotNull AirplaneType type) {
        this.name = name;
        this.factorySerialNumber = factorySerialNumber;
        this.aircompany = aircompany;
        this.numberOfFlights = numberOfFlights;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactorySerialNumber() {
        return factorySerialNumber;
    }

    public void setFactorySerialNumber(String factorySerialNumber) {
        this.factorySerialNumber = factorySerialNumber;
    }

    public Aircompany getAircompany() {
        return aircompany;
    }

    public void setAircompany(Aircompany aircompany) {
        this.aircompany = aircompany;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public void setNumberOfFlights(int numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }

    public double getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(double flightDistance) {
        this.flightDistance = flightDistance;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public AirplaneType getType() {
        return type;
    }

    public void setType(AirplaneType type) {
        this.type = type;
    }
}
