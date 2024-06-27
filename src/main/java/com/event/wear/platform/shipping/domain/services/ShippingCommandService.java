package com.event.wear.platform.shipping.domain.services;

import com.event.wear.platform.shipping.domain.model.commands.*;

public interface ShippingCommandService {

    void handle(CreateShippingCommand command);

}
