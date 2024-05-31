package com.event.wear.platform.Rent.domain.services;

import com.event.wear.platform.Rent.domain.model.commands.*;

public interface RentCommandService {
    void handle(DeleteCartItemCommand command);
    void handle(AddItemToCartCommand command);
    void handle(UpdateCartItemCommand command);
}