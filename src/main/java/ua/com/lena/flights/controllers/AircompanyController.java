package ua.com.lena.flights.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.lena.flights.entities.Aircompany;
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
    public ResponseEntity<Aircompany> getAircompany(@PathVariable long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aircompany> create(@RequestBody @Valid Aircompany aircompany) {
        if (service.getByName(aircompany.getName()).isPresent()) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        service.save(aircompany);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody @Valid Aircompany aircompany) {
        return service.getById(id)
                .map(company -> {
                    service.update(id, aircompany);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!service.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        if (service.remove(id) > 0) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
