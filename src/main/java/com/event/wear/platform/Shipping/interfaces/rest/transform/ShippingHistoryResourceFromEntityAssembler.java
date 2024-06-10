package com.event.wear.platform.Shipping.interfaces.rest.transform;


import com.event.wear.platform.Shipping.domain.model.aggregates.ShippingHistory;
import com.event.wear.platform.Shipping.interfaces.rest.resources.ShippingHystoryResource;

public class ShippingHistoryResourceFromEntityAssembler {
    public static ShippingHystoryResource toResourceFromEntity(ShippingHistory entity) {
        return new ShippingHystoryResource(entity.getId(), entity.getUserId(), entity.getShippingIds());
    }
}
