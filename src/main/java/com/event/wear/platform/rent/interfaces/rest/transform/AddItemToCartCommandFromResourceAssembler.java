package com.event.wear.platform.rent.interfaces.rest.transform;

import com.event.wear.platform.rent.domain.model.commands.AddItemToCartCommand;
import com.event.wear.platform.rent.interfaces.rest.resources.AddItemToCartResource;
import org.springframework.stereotype.Component;

@Component
public class AddItemToCartCommandFromResourceAssembler {
    public AddItemToCartCommand toCommandFromResource(AddItemToCartResource resource) {
        Long shoppingId = resource.getUserId().value();
        Long userId = resource.getUserId().value();
        return new AddItemToCartCommand(userId, shoppingId, resource.getPublicationId().value(), resource.quantity());
    }

}