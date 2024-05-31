package com.event.wear.platform.Rent.application.internal.commandservices;

import com.event.wear.platform.Rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.Rent.domain.model.commands.*;
import com.event.wear.platform.Rent.domain.model.entities.CartItem;
import com.event.wear.platform.Rent.domain.services.RentCommandService;
import com.event.wear.platform.Rent.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShoppingCommandsServicesImpl implements RentCommandService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCommandsServicesImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    @Transactional
    public void handle(DeleteCartItemCommand command) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(command.cartItemId())
                .orElseThrow(() -> new IllegalArgumentException("ShoppingCart not found"));
        shoppingCart.getItems().removeIf(item -> item.getId().equals(command.cartItemId()));
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    @Transactional
    public void handle(AddItemToCartCommand command) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(command.shoppingCartId())
                .orElseThrow(() -> new IllegalArgumentException("ShoppingCart not found"));
        CartItem newItem = new CartItem(shoppingCart, command.publicationId(), command.quantity());
        shoppingCart.getItems().add(newItem);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    @Transactional
    public void handle(UpdateCartItemCommand command) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(command.shoppingCartId())
                .orElseThrow(() -> new IllegalArgumentException("ShoppingCart not found"));
        CartItem itemToUpdate = shoppingCart.getItems().stream()
                .filter(item -> item.getId().equals(command.cartItemId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("CartItem not found"));
        itemToUpdate.setQuantity(command.newQuantity());
        shoppingCartRepository.save(shoppingCart);
    }
}