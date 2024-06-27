package com.event.wear.platform.shipping.domain.model.commands;

import com.event.wear.platform.shipping.domain.model.aggregates.Shipping;

import java.util.List;

public record CreateHistoryCommand(Long shippingId) {
}
