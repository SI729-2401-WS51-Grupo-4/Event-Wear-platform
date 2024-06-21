package com.event.wear.platform.rent.domain.services;

import com.event.wear.platform.rent.domain.model.commands.*;

public interface ShoppingCartCommandService {
    void handle(DeleteCartItemCommand command);
    void handle(AddCartItemCommand command);
    void handle(UpdateCartItemCommand command);
}