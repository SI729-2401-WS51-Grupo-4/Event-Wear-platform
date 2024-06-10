package com.event.wear.platform.rent.interfaces.rest.transform;

import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.interfaces.rest.resources.CartItemResource;

public class CartItemResourceFromEntityAssembler {
    public static CartItemResource toResourceFromEntity(CartItem cartItem) {
        return new CartItemResource(
                cartItem.getUserId().userId(),
                cartItem.getPublicationId().publicationId(),
                (long) cartItem.getQuantity()
        );
    }
}
