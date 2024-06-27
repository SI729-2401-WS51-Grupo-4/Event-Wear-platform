package com.event.wear.platform.shipping.interfaces.rest.transform;

import com.event.wear.platform.shipping.domain.model.commands.CreateShippingCommand;
import com.event.wear.platform.shipping.domain.model.entities.ShippingDetails;
import com.event.wear.platform.shipping.interfaces.rest.resources.CreateItemToShippingResource;

import java.util.List;

public class CreateShippingResoruceFromResourceAssembler {

    public static CreateShippingCommand toCommandFromResource(CreateItemToShippingResource resource) {
        return new CreateShippingCommand(
                resource.address(),
                resource.deadline(),
                resource.startdate(),
                resource.trackingstatus(),
                resource.remainingDaysValue(),
                resource.rentId(),
                resource.shippingDetails()
                //resource.shipping_history_id()
        );
    }

}