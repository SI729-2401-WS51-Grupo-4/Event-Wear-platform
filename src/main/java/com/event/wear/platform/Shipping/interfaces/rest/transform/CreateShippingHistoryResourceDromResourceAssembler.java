package com.event.wear.platform.Shipping.interfaces.rest.transform;

import com.event.wear.platform.Shipping.domain.model.commands.CreateShippingHistoryCommand;
import com.event.wear.platform.Shipping.interfaces.rest.resources.CreateShippingHistoryResource;

public class CreateShippingHistoryResourceDromResourceAssembler {
    public static CreateShippingHistoryCommand toCommandFromResource(CreateShippingHistoryResource resource) {
        return new CreateShippingHistoryCommand( resource.userid(), resource.Shipping_id());
    }

}
