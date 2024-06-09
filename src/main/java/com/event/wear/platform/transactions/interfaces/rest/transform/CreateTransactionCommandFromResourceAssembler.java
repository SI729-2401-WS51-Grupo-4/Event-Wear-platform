package com.event.wear.platform.transactions.interfaces.rest.transform;

import com.event.wear.platform.transactions.domain.model.commands.CreateTransactionCommand;
import com.event.wear.platform.transactions.interfaces.rest.resources.CreateTransactionResource;

public class CreateTransactionCommandFromResourceAssembler {
    public static CreateTransactionCommand toCommandFromResource(CreateTransactionResource resource) {
        return new CreateTransactionCommand(resource.transactionId(), resource.rentId(), resource.userId(), resource.lessorId(),
                resource.amount(), resource.date(), resource.paymentMethod(), resource.paymentDetails());
    }
}
