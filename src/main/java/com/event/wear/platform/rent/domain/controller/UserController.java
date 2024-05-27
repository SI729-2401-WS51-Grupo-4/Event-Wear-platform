package com.event.wear.platform.rent.domain.controller;

import com.event.wear.platform.rent.domain.exceptions.ResourceNotFoundException;
import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.model.entities.ShoppingCart;
import com.event.wear.platform.rent.domain.model.entities.User;
import com.event.wear.platform.rent.domain.service.UserService;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/isEmpty")
    public boolean isUserListEmpty() {
        List<User> users = userRepository.findAll();
        return users.isEmpty();
    }
    @GetMapping
    public List<User> getAllUsers() {
    return userService.getAllUsers();
    }

    @GetMapping("/{userId}/Cart")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Long userId) {
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    ShoppingCart cart = user.getShoppingCart();
    if (cart == null) {
        throw new ResourceNotFoundException("ShoppingCart", "userId", userId);
    }
    return ResponseEntity.ok(cart.getItems());
}



    /*@PostMapping("/create")
    public ResponseEntity<?> createUsers() {
        userService.createUsers(); // Call createUsers() method of UserService
        return ResponseEntity.ok().build();
    }*/
}