package com.event.wear.platform.Shipping.domain.services;

import com.event.wear.platform.Shipping.domain.model.commands.CreateShippingHistoryCommand;
import com.event.wear.platform.Shipping.domain.model.commands.AddShippingToShippingHisotryCommand;

public interface ShippingHistoryCommandService {
    void handle(CreateShippingHistoryCommand command);
    void handle(AddShippingToShippingHisotryCommand command);
}