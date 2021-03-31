package ua.com.lena.flights.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.com.lena.flights.exceptions.AircompanyDuplicateNameException;
import ua.com.lena.flights.exceptions.AirplaneDuplicateSerialNumberException;
import ua.com.lena.flights.exceptions.EntityNotFoundException;
import ua.com.lena.flights.exceptions.FlightDistanceException;

@RestControllerAdvice
public class WebAppExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFound(EntityNotFoundException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AircompanyDuplicateNameException.class)
    public ResponseEntity handleAircompanyDuplicateName(AircompanyDuplicateNameException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(FlightDistanceException.class)
    public ResponseEntity handleFlightDistance(FlightDistanceException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AirplaneDuplicateSerialNumberException.class)
    public ResponseEntity handleAirplaneDuplicateSerialNumber(AirplaneDuplicateSerialNumberException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }
}
