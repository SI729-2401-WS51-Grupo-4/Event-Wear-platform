package com.event.wear.platform.transactions.domain.services;

import com.event.wear.platform.transactions.domain.model.commands.CreateTransactionHistoryCommand;
import com.event.wear.platform.transactions.domain.model.commands.AddTransactionToTransactionHistoryCommand;
import com.event.wear.platform.transactions.domain.model.commands.DeleteTransactionFromTransactionHistoryCommand;

public interface TransactionHistoryCommandService {
    Long handle(CreateTransactionHistoryCommand command);
    Long handle(AddTransactionToTransactionHistoryCommand command);
    boolean handle(DeleteTransactionFromTransactionHistoryCommand command);
}