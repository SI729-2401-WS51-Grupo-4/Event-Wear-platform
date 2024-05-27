package com.event.wear.platform.rent.domain.service;

import com.event.wear.platform.rent.domain.exceptions.ResourceNotFoundException;
import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.model.entities.Product;
import com.event.wear.platform.rent.domain.model.entities.ShoppingCart;
import com.event.wear.platform.rent.domain.model.entities.User;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.CartItemRepository;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.UserRepository;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public Product selectProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }

    public void addProductToCart(Long userId, Long productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Product product = selectProduct(productId);

        ShoppingCart cart = user.getShoppingCart();
        if (cart == null) {
            cart = new ShoppingCart();
            cart.setUser(user);
            user.setShoppingCart(cart);
            userRepository.save(user);
        }
        CartItem item = new CartItem();
        item.setProduct(product);
        item.setShoppingCart(cart);

        cartItemRepository.save(item);
    }
}