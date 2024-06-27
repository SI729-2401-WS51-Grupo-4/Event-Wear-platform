package com.event.wear.platform.shipping.interfaces.rest.transform;


import com.event.wear.platform.shipping.domain.model.commands.CreateHistoryCommand;
import com.event.wear.platform.shipping.interfaces.rest.resources.CreateItemtoShippingHistory;

public class CreateShippingHistoryResourseFromResourceAssembler {

    public static CreateHistoryCommand toCommandFromResource(CreateItemtoShippingHistory resource) {
        return new CreateHistoryCommand(
                resource.shippingId()
                //resource.shippings()
        );
    }

}
