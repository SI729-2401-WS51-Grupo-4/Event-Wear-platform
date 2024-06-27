package com.event.wear.platform.transactions.interfaces.rest.transform;

import com.event.wear.platform.transactions.domain.model.commands.DeleteTransactionFromTransactionHistoryCommand;
import com.event.wear.platform.transactions.interfaces.rest.resources.DeleteTransactionFromTransactionHistoryResource;

public class DeleteTransactionFromTransactionHistoryCommandFromResourceAssembler {
    public static DeleteTransactionFromTransactionHistoryCommand toCommandFromResource(DeleteTransactionFromTransactionHistoryResource resource){
        return new DeleteTransactionFromTransactionHistoryCommand(resource.transactionHistoryId(), resource.transactionId());
    }
}
