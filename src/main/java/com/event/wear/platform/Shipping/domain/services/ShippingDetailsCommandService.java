package com.event.wear.platform.Shipping.domain.services;

import com.event.wear.platform.Shipping.domain.model.commands.CreateDetailsCommand;
import com.event.wear.platform.Shipping.domain.model.commands.DeleteDetailsCommand;

public interface ShippingDetailsCommandService {
    void handle(CreateDetailsCommand command);
    void handle(DeleteDetailsCommand command);
}