package com.event.wear.platform.shipping.domain.services;


import com.event.wear.platform.shipping.domain.model.commands.CreateDetailsCommand;

public interface ShippingDetailsCommandService {

    void handle(CreateDetailsCommand command);

}
