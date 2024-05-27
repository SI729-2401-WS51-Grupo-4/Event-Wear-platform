package com.event.wear.platform.rent.domain.controller;

import com.event.wear.platform.rent.domain.service.ShoppingCartService;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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