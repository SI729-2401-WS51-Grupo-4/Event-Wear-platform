package com.event.wear.platform.transactions.interfaces.rest.transform;

import com.event.wear.platform.transactions.domain.model.commands.CreateTransactionHistoryCommand;
import com.event.wear.platform.transactions.interfaces.rest.resources.CreateTransactionHistoryResource;
import com.event.wear.platform.transactions.interfaces.rest.resources.CreateTransactionResource;

public class CreateTransactionHistoryCommandFromResourceAssembler {
    public static CreateTransactionHistoryCommand toCommandFromResource(CreateTransactionHistoryResource resource){
        return new CreateTransactionHistoryCommand();
    }
}
