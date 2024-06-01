package com.event.wear.platform.rent.interfaces.rest.transform;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.commands.AddItemToCartCommand;
import com.event.wear.platform.rent.interfaces.rest.resources.AddItemToCartResource;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import org.springframework.stereotype.Component;

@Component
public class AddItemToCartCommandFromResourceAssembler {

   public AddItemToCartCommand toCommandFromResource(UserId userId, ShoppingCart shoppingCart, AddItemToCartResource resource) {
    return new AddItemToCartCommand(userId, shoppingCart, resource.publicationId(), resource.quantity());
   }
}