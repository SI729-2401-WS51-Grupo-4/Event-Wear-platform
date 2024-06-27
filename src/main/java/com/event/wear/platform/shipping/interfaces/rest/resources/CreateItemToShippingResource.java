package com.event.wear.platform.shipping.interfaces.rest.resources;

import com.event.wear.platform.shipping.domain.model.entities.ShippingDetails;
import com.event.wear.platform.shipping.domain.model.valueobjects.TrackingStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CreateItemToShippingResource(
        String address,
        LocalDate deadline,
        Long rentId,
        List<ShippingDetails>shippingDetails
        //Long shipping_history_id
) {}