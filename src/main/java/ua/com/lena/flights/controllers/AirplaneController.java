package ua.com.lena.flights.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.lena.flights.entities.Airplane;
import ua.com.lena.flights.service.AirplaneService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class AirplaneController {
    private final AirplaneService service;

    public AirplaneController(AirplaneService service) {
        this.service = service;
    }

    @PatchMapping("/{airplaneId}/{aircompanyId}")
    public Airplane changeAircompany(@PathVariable long airplaneId, @PathVariable long aircompanyId) {
        return service.changeAircompany(airplaneId, aircompanyId);
    }

    @PostMapping("/airplanes")
    public ResponseEntity<Airplane> create(@RequestParam long companyId, @RequestBody @Valid Airplane airplane) {
        return new ResponseEntity(service.save(companyId, airplane), HttpStatus.CREATED);
    }
}
