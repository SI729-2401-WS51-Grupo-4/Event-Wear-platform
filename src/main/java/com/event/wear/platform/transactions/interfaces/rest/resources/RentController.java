package com.event.wear.platform.transactions.interfaces.rest.resources;

import com.event.wear.platform.transactions.domain.model.entities.Rent;
import com.event.wear.platform.transactions.infrastructure.persistence.jpa.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rents")
public class RentController {
    @Autowired
    private RentRepository rentRepository;

    @GetMapping
    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    @PostMapping
    public Rent createRent(@RequestBody Rent rent) {
        return rentRepository.save(rent);
    }

    // Agrega otros métodos CRUD según sea necesario
}