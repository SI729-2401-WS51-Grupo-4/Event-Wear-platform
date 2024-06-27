package com.event.wear.platform.shipping.domain.services;

import com.event.wear.platform.shipping.domain.model.commands.CreateHistoryCommand;

public interface ShippingHistoryCommandService {

    void handle(CreateHistoryCommand command);

}
