package ua.com.lena.flights.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.lena.flights.entities.Aircompany;
import ua.com.lena.flights.entities.Airplane;
import ua.com.lena.flights.service.AircompanyService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/aircompanies")
public class AircompanyController {
    private final AircompanyService service;

    public AircompanyController(AircompanyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aircompany> getAircompanies() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Aircompany getAircompany(@PathVariable long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<Airplane> create(@RequestBody @Valid Aircompany aircompany) {
        return new ResponseEntity(service.save(aircompany), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Aircompany update(@PathVariable long id, @RequestBody @Valid Aircompany aircompany) {
        return service.update(id, aircompany);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return service.remove(id) > 0 ? ResponseEntity.noContent().build() : ResponseEntity.unprocessableEntity().build();
    }
}
