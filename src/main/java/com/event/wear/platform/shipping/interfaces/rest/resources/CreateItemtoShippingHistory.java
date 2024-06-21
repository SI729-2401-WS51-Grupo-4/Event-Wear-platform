package com.event.wear.platform.shipping.interfaces.rest.resources;

import com.event.wear.platform.shipping.domain.model.aggregates.Shipping;

import java.util.List;

public record CreateItemtoShippingHistory(
        Long shippingId
        //List<Shipping> shippings
) {
}
