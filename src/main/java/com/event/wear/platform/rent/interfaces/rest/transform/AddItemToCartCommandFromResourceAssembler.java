package com.event.wear.platform.rent.interfaces.rest.transform;
import com.event.wear.platform.rent.domain.model.commands.AddCartItemCommand;
import com.event.wear.platform.rent.interfaces.rest.resources.AddItemToCartResource;
import org.springframework.stereotype.Component;

@Component
public class AddItemToCartCommandFromResourceAssembler {
   public static AddCartItemCommand toCommandFromResource(Long userId, AddItemToCartResource resource) {
        return new AddCartItemCommand(
                userId,
                resource.publicationId(),
                resource.quantity()
        );
   }
}