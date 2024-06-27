package com.event.wear.platform.rent.interfaces.rest.transform;

import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.interfaces.rest.resources.CartItemResource;

public class CartItemResourceFromEntityAssembler {
    public CartItemResource toResourceFromEntity(CartItem entity) {
        return new CartItemResource(
                entity.getUserId().userId(),
                entity.getPublicationId().publicationId(),
                entity.getQuantity()
        );
    }

}

