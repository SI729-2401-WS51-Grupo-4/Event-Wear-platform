package com.event.wear.platform.Shipping.interfaces.rest.transform;

import com.event.wear.platform.Shipping.domain.model.entities.ShippingDetails;
import com.event.wear.platform.Shipping.interfaces.rest.resources.DetailsResource;

public class DetailsResourceFromEntityAssembler
{
    public static DetailsResource toResourceFromEntity(ShippingDetails entity) {
        return new DetailsResource(entity.getId(), entity.getDescription(), entity.getImportancelevel());
    }
}
