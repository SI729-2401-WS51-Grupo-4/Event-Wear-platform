package com.event.wear.platform.rent.interfaces.rest.transform;
import com.event.wear.platform.rent.domain.model.commands.AddCartItemCommand;
import com.event.wear.platform.rent.interfaces.rest.resources.AddItemToCartResource;
import org.springframework.stereotype.Component;

@Component
public class AddItemToCartCommandFromResourceAssembler {
    public AddCartItemCommand toCommandFromResource(AddItemToCartResource resource) {
        return new AddCartItemCommand(resource.userId(),resource.publicationId(), resource.quantity());

    }

}