package com.event.wear.platform.rent.domain.services;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.commands.AddCartItemCommand;
import com.event.wear.platform.rent.domain.model.commands.CreateShoppingCartCommand;
import com.event.wear.platform.rent.domain.model.commands.DeleteCartItemCommand;
import com.event.wear.platform.rent.domain.model.commands.UpdateCartItemCommand;
import com.event.wear.platform.rent.domain.model.entities.CartItem;

public interface ShoppingCartCommandService {
    ShoppingCart handle(CreateShoppingCartCommand command);
    void handle(DeleteCartItemCommand command);
    CartItem handle(AddCartItemCommand command);
    void handle (UpdateCartItemCommand command);
}