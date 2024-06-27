package com.event.wear.platform.shipping.domain.model.commands;

import com.event.wear.platform.shipping.domain.model.valueobjects.TrackingStatus;
import com.event.wear.platform.shipping.domain.model.entities.ShippingDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CreateShippingCommand(
        String address,
        LocalDate deadline,
        Long rentId,
        List<ShippingDetails>shippingDetailsIds
        //Long shipping_history_id
) {}