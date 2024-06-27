package com.event.wear.platform.shipping.interfaces.rest.resources;

import com.event.wear.platform.shipping.domain.model.entities.ShippingDetails;
import com.event.wear.platform.shipping.domain.model.valueobjects.TrackingStatus;

import java.time.LocalDateTime;
import java.util.List;

public record CreateItemToShippingResource(
        String address,
        LocalDateTime deadline,
        LocalDateTime startdate,
        TrackingStatus trackingstatus,
        int remainingDaysValue,
        Long rentId,
        List<ShippingDetails>shippingDetails
        //Long shipping_history_id
) {}