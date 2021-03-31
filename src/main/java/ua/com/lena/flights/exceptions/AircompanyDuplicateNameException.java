package ua.com.lena.flights.exceptions;

public class AircompanyDuplicateNameException extends RuntimeException {
    public AircompanyDuplicateNameException(String message) {
        super(message);
    }
}
