package com.event.wear.platform.rent.domain.services;

import com.event.wear.platform.rent.domain.model.commands.*;

public interface RentCommandService {
    void handle(DeleteCartItemCommand command);
    void handle(AddItemToCartCommand command);
    void handle(UpdateCartItemCommand command);
}