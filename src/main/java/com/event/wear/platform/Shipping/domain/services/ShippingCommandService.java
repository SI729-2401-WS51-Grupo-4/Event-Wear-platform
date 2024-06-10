package com.event.wear.platform.Shipping.domain.services;

import com.event.wear.platform.Shipping.domain.model.commands.AddDetailsToShippingCommand;
import com.event.wear.platform.Shipping.domain.model.commands.CancelShippingCommand;
import com.event.wear.platform.Shipping.domain.model.commands.CreateShippingCommand;

public interface ShippingCommandService {

    void handle(AddDetailsToShippingCommand command);
    void handle(CreateShippingCommand command);
    void handle(CancelShippingCommand command);
}
