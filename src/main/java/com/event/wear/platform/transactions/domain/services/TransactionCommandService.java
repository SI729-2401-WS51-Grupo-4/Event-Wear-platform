package com.event.wear.platform.transactions.domain.services;

import com.event.wear.platform.transactions.domain.model.commands.AddRentToTransactionCommand;
import com.event.wear.platform.transactions.domain.model.commands.CreateTransactionCommand;

public interface TransactionCommandService {
    Long handle(AddRentToTransactionCommand command);
    Long handle(CreateTransactionCommand command);
}