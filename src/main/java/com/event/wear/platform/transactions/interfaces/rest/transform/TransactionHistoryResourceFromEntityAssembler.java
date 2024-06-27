package com.event.wear.platform.transactions.interfaces.rest.transform;

import com.event.wear.platform.transactions.domain.model.aggregates.TransactionHistory;
import com.event.wear.platform.transactions.interfaces.rest.resources.TransactionHistoryResource;

public class TransactionHistoryResourceFromEntityAssembler {
    public static TransactionHistoryResource toResourceFromEntity(TransactionHistory entity){
        return new TransactionHistoryResource(entity.getId(), entity.getTransactionList());
    }
}
