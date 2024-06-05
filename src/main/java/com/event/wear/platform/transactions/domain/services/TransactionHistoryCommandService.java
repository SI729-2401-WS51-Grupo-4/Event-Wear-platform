package com.event.wear.platform.transactions.domain.services;

import com.event.wear.platform.transactions.domain.model.commands.AddTransactionHistoryCommand;
import com.event.wear.platform.transactions.domain.model.commands.AddTransactionToTransactionHistoryCommand;
import com.event.wear.platform.transactions.domain.model.commands.DeleteTransactionFromTransactionHistoryCommand;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionHistoryId;

public interface TransactionHistoryCommandService {
    Long handle(AddTransactionHistoryCommand command);
    Long handle(AddTransactionToTransactionHistoryCommand command);
    boolean handle(DeleteTransactionFromTransactionHistoryCommand command);
}