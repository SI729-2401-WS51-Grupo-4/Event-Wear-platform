package com.event.wear.platform.rent.application.internal.commandservices;

import com.event.wear.platform.rent.domain.model.valueobjects.PublicationId;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.commands.*;
import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.services.ShoppingCartCommandService;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShoppingCommandsServicesImpl implements ShoppingCartCommandService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCommandsServicesImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }


    @Override
    public void handle(AddCartItemCommand command) {
        Long userId = command.userId();
        ShoppingCart shoppingCart = shoppingCartRepository.findById(userId)
                .orElseGet(() -> {
                    ShoppingCart newCart = new ShoppingCart();
                    newCart.setUserId(userId);
                    return newCart;
                });
        UserId userIdInstance = new UserId(userId);
        PublicationId publicationIdInstance = new PublicationId(command.publicationId());
        int quantity = Math.toIntExact(command.quantity());
    CartItem newItem = new CartItem(userIdInstance, publicationIdInstance, quantity);
        shoppingCart.addItem(newItem);
        shoppingCartRepository.save(shoppingCart);
        newItem.getId();
    }

    @Override
    @Transactional
    public void handle(DeleteCartItemCommand command) {
    Long userId = command.userId();
    ShoppingCart shoppingCart = shoppingCartRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("ShoppingCart not found"));
    CartItem itemToRemove = shoppingCart.getItems().stream()
            .filter(item -> item.getId().equals(command.cartItemId()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("CartItem not found"));
    shoppingCart.removeItem(itemToRemove);
    shoppingCartRepository.save(shoppingCart);
    }

    @Override
    @Transactional
    public void handle(UpdateCartItemCommand command) {
    Long userId = command.userId();
    ShoppingCart shoppingCart = shoppingCartRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("ShoppingCart not found"));
    CartItem itemToUpdate = shoppingCart.getItems().stream()
            .filter(item -> item.getId().equals(command.cartItemId()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("CartItem not found"));
    shoppingCart.updateItemQuantity(itemToUpdate, command.newQuantity());
    shoppingCartRepository.save(shoppingCart);
    }

}