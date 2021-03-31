package ua.com.lena.flights.exceptions;

public class FlightDistanceException extends RuntimeException{
    public FlightDistanceException(String message) {
        super(message);
    }
}
