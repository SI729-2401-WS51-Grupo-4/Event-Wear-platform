package com.event.wear.platform.rent.application.internal.commandservices;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.commands.*;
import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import com.event.wear.platform.rent.domain.services.RentCommandService;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
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
    UserId userId = new UserId(command.cartItemId());
    ShoppingCart shoppingCart = shoppingCartRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("ShoppingCart not found"));
    shoppingCart.getItems().removeIf(item -> item.getId().equals(command.cartItemId()));
    shoppingCartRepository.save(shoppingCart);
    }


@Override
public Long handle(AddItemToCartCommand command) {
    UserId userId = command.userId();
    ShoppingCart shoppingCart = shoppingCartRepository.findById(userId)
            .orElseGet(() -> {
                ShoppingCart newCart = new ShoppingCart();
                newCart.setUserId(userId);
                return newCart;
            });
    CartItem newItem = new CartItem(userId, command.publicationId(), command.quantity());

    shoppingCart.addItem(newItem);

    // Save the ShoppingCart with the new CartItem
    shoppingCartRepository.save(shoppingCart);

    return (Long) newItem.getId();
}


    @Override
@Transactional
public void handle(UpdateCartItemCommand command) {
    UserId userId = new UserId(command.shoppingCartId());
    ShoppingCart shoppingCart = shoppingCartRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("ShoppingCart not found"));
    CartItem itemToUpdate = shoppingCart.getItems().stream()
            .filter(item -> item.getId().equals(command.cartItemId()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("CartItem not found"));
    itemToUpdate.setQuantity(command.newQuantity());
    shoppingCartRepository.save(shoppingCart);
}
}