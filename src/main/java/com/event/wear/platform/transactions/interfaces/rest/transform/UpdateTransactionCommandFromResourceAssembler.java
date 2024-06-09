package com.event.wear.platform.transactions.interfaces.rest.transform;

import com.event.wear.platform.transactions.domain.model.aggregates.Transaction;
import com.event.wear.platform.transactions.domain.model.commands.UpdateTransactionCommand;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;
import com.event.wear.platform.transactions.interfaces.rest.resources.UpdateTransactionResource;

public class UpdateTransactionCommandFromResourceAssembler {
    public static UpdateTransactionCommand toCommandFromResource(Long transactionId, UpdateTransactionResource resource) {
        return new UpdateTransactionCommand(new Transaction(transactionId, resource.rentId(), resource.userId(), resource.lessorId(),
                resource.amount(), resource.date(), resource.paymentMethod(), resource.paymentDetails()), new TransactionId(transactionId));
    }
}