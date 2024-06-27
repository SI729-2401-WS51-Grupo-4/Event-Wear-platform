package com.event.wear.platform.transactions.interfaces.rest.transform;

import com.event.wear.platform.transactions.domain.model.commands.AddTransactionToTransactionHistoryCommand;
import com.event.wear.platform.transactions.interfaces.rest.resources.AddTransactionToTransactionHistoryResource;

public class AddTransactionToTransactionHistoryCommandFromResourceAssembler {
    public static AddTransactionToTransactionHistoryCommand toCommandFromResource(AddTransactionToTransactionHistoryResource resource){
        return new AddTransactionToTransactionHistoryCommand(resource.transactionHistoryId(), resource.transactionId());
    }
}
