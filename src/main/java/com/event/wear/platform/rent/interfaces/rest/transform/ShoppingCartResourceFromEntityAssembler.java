package com.event.wear.platform.rent.interfaces.rest.transform;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.interfaces.rest.resources.ShoppingCartResource;

public class ShoppingCartResourceFromEntityAssembler {
    public static ShoppingCartResource toResourceFromEntity(ShoppingCart entity) {
        return new ShoppingCartResource(entity.getId());
    }
}
