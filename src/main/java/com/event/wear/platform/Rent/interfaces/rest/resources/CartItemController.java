package com.event.wear.platform.Rent.interfaces.rest.resources;

import com.event.wear.platform.Rent.domain.model.entities.CartItem;
import com.event.wear.platform.Rent.infrastructure.persistence.jpa.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartitems")
public class CartItemController {
    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @PostMapping
    public CartItem createCartItem(@RequestBody CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    // Agrega otros métodos CRUD según sea necesario
}