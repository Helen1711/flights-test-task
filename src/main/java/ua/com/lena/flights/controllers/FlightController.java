package ua.com.lena.flights.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.lena.flights.entities.Flight;
import ua.com.lena.flights.entities.FlightStatus;
import ua.com.lena.flights.service.FlightService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {
    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @GetMapping
    public List<Flight> getFlights(@RequestParam FlightStatus status, @RequestParam String name){
        return service.getAllByStatusAndAircompanyName(status, name);
    }

    @GetMapping("/active")
    public List<Flight> getFlightsByStatusAndStartedTime(){
        return service.getAllByStatusAndStartedTime();
    }

    @PostMapping
    public ResponseEntity<Flight> create(@RequestBody @Valid Flight flight, @RequestParam long companyId,
                                         @RequestParam long airplaneId){
        service.save(companyId, airplaneId, flight);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
