package com.event.wear.platform.transactions.interfaces.rest.transform;

import com.event.wear.platform.transactions.domain.model.aggregates.Transaction;
import com.event.wear.platform.transactions.interfaces.rest.resources.TransactionResource;

public class TransactionResourceFromEntityAssembler {
    public static TransactionResource toResourceFromEntity(Transaction entity) {
        return new TransactionResource(entity.getId(), entity.getRentId().rentId(), entity.getUserId().userId(), entity.getLessorId().lessorId(),
                entity.getAmount(), entity.getDate(), entity.getPaymentMethod(), entity.getPaymentDetails());
    }
}