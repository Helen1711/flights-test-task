package ua.com.lena.flights.controllers;

import org.springframework.web.bind.annotation.*;
import ua.com.lena.flights.entities.Flight;
import ua.com.lena.flights.entities.FlightStatus;
import ua.com.lena.flights.service.FlightService;

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
    public List<Flight> all(@RequestParam FlightStatus status, @RequestParam String name){
        return service.getAllByStatusAndAircompanyName(status, name);
    }
}
