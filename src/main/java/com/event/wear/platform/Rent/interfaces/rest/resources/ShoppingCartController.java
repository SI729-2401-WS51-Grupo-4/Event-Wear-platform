package com.event.wear.platform.Rent.interfaces.rest.resources;

import com.event.wear.platform.Rent.domain.model.entities.ShoppingCart;
import com.event.wear.platform.Rent.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @GetMapping
    public List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    @PostMapping
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    // Agrega otros métodos CRUD según sea necesario
}