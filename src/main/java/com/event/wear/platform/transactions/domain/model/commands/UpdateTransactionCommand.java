package com.event.wear.platform.transactions.domain.model.commands;

import com.event.wear.platform.transactions.domain.model.aggregates.TransactionAggregate;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;

public record UpdateTransactionCommand(TransactionAggregate transactionAggregate, TransactionId transactionId) {
}
