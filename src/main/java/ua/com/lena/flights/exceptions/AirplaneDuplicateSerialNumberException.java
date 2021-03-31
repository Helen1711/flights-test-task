package ua.com.lena.flights.exceptions;

public class AirplaneDuplicateSerialNumberException extends RuntimeException {
    public AirplaneDuplicateSerialNumberException(String message) {
        super(message);
    }
}
