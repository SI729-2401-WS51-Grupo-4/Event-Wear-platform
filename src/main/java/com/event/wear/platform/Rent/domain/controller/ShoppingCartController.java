package com.event.wear.platform.Rent.domain.controller;

import com.event.wear.platform.Rent.domain.exceptions.ResourceNotFoundException;
import com.event.wear.platform.Rent.domain.model.entities.CartItem;
import com.event.wear.platform.Rent.domain.model.entities.ShoppingCart;
import com.event.wear.platform.Rent.domain.service.ShoppingCartService;
import com.event.wear.platform.Rent.infrastructure.persistence.jpa.repositories.UserRepository; // Import UserRepository
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service("shoppingCartController1")
@RestController
@RequestMapping("/users/{userId}/cart/products")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private UserRepository userRepository; // Autowire UserRepository

    @PostMapping("/{productId}")
    public ResponseEntity<?> addProductToCart(@PathVariable Long userId, @PathVariable Long productId) {
        shoppingCartService.addProductToCart(userId, productId);
        return ResponseEntity.ok().build();
    }

}