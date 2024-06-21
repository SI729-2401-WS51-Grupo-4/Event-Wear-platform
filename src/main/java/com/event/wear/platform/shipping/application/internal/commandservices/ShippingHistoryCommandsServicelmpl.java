package com.event.wear.platform.shipping.application.internal.commandservices;

import com.event.wear.platform.shipping.domain.model.aggregates.Shipping;
import com.event.wear.platform.shipping.domain.model.aggregates.ShippingHistory;
import com.event.wear.platform.shipping.domain.model.commands.CreateHistoryCommand;
import com.event.wear.platform.shipping.domain.services.ShippingHistoryCommandService;
import com.event.wear.platform.shipping.infrastructure.persistence.jpa.repositories.ShippingHistoryRepository;
import com.event.wear.platform.shipping.infrastructure.persistence.jpa.repositories.ShippingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
/*
@Service
public class ShippingHistoryCommandsServicelmpl implements ShippingHistoryCommandService {

    private final ShippingHistoryRepository shippingHistoryRepository;
    private final ShippingRepository shippingRepository;

    public ShippingHistoryCommandsServicelmpl(ShippingHistoryRepository shippingHistoryRepository, ShippingRepository shippingRepository) {
        this.shippingHistoryRepository = shippingHistoryRepository;
        this.shippingRepository = shippingRepository;
    }


    @Override
    public void handle(CreateHistoryCommand command) {
        ShippingHistory newShippingHistory = new ShippingHistory(command.shippingId());

        Shipping matchingShipping = shippingRepository.findById(command.shippingId())
                .orElseThrow(() -> new IllegalArgumentException("Shipping with id " + command.shippingId() + " not found"));

        newShippingHistory.addShipping(matchingShipping);

        shippingHistoryRepository.save(newShippingHistory);
    }


}
*/