package com.event.wear.platform.rent.interfaces.rest.transform;

import com.event.wear.platform.rent.domain.model.commands.UpdateCartItemCommand;
import com.event.wear.platform.rent.interfaces.rest.resources.UpdateCartItemResource;
import org.springframework.stereotype.Component;

@Component
public class UpdateCartItemCommandFromResourceAssembler {
    public static UpdateCartItemCommand toCommandFromResource(Long userId, Long cartItemId,UpdateCartItemResource resource) {
        return new UpdateCartItemCommand(userId,cartItemId,resource.newQuantity()
        );
    }

}