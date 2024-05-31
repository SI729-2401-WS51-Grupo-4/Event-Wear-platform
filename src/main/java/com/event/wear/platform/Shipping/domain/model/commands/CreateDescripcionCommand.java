package com.event.wear.platform.Shipping.domain.model.commands;

public record CreateDescripcionCommand(long shippingid, String description, String importancelevel) {
}
