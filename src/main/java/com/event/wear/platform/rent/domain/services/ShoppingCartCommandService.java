package com.event.wear.platform.rent.domain.services;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.commands.*;
import com.event.wear.platform.rent.domain.model.entities.CartItem;

import java.util.Optional;

public interface ShoppingCartCommandService {
    void handle(DeleteCartItemCommand command);
    CartItem handle(AddCartItemCommand command);
    Optional<ShoppingCart> handle(UpdateCartItemCommand command);
}