package com.event.wear.platform.transactions.domain.model.commands;

import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionHistoryId;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;

public record DeleteTransactionFromTransactionHistoryCommand(TransactionHistoryId transactionHistoryId, TransactionId transactionId) {
}
