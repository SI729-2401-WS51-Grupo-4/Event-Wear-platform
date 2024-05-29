package com.event.wear.platform.transactions.domain.services;

import com.event.wear.platform.transactions.domain.model.aggregates.TransactionAggregate;
import com.event.wear.platform.transactions.domain.model.commands.AddRentToTransactionCommand;
import com.event.wear.platform.transactions.domain.model.commands.AddTransactionCommand;
import com.event.wear.platform.transactions.domain.model.commands.UpdateTransactionCommand;

public interface TransactionCommandService {
    Long handle(AddRentToTransactionCommand command);
    Long handle(AddTransactionCommand command);
    TransactionAggregate handle(UpdateTransactionCommand command);
}