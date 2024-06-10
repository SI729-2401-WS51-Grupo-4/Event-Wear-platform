package com.event.wear.platform.Shipping.interfaces.rest.transform;

import com.event.wear.platform.Shipping.domain.model.aggregates.Shipping;
import com.event.wear.platform.Shipping.interfaces.rest.resources.ShippingResource;

public class ShippingResourceFromEntityAssembler {

    public static ShippingResource toResourceFromEntity(Shipping entity ) {
        return new ShippingResource(entity.getId(), entity.getAddress(), entity.getDeadline(), entity.getStartdate(), entity.getStatus(), entity.getShippingDetails().toString(), entity.getUserId());
    }

}
