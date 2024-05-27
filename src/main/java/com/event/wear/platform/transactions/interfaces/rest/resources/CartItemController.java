package com.event.wear.platform.transactions.interfaces.rest.resources;

import com.event.wear.platform.transactions.domain.model.entities.CartItem;
import com.event.wear.platform.transactions.infrastructure.persistence.jpa.repositories.CartItemRepository;
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