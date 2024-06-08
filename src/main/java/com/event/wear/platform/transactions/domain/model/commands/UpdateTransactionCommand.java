package com.event.wear.platform.transactions.domain.model.commands;

import com.event.wear.platform.transactions.domain.model.aggregates.Transaction;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;

public record UpdateTransactionCommand(Transaction transaction, TransactionId transactionId) {
}
