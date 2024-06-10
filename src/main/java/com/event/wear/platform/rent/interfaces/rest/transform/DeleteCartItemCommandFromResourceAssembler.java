package com.event.wear.platform.rent.interfaces.rest.transform;

import com.event.wear.platform.rent.domain.model.commands.DeleteCartItemCommand;
import com.event.wear.platform.rent.interfaces.rest.resources.DeleteCartItemResource;
import org.springframework.stereotype.Component;

@Component
public class DeleteCartItemCommandFromResourceAssembler {
    public DeleteCartItemCommand toCommandFromResource(DeleteCartItemResource resource) {
        return new DeleteCartItemCommand(resource.getUserId().userId(), resource.cartItemId());
    }

}