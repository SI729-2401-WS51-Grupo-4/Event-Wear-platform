package com.event.wear.platform.transactions.interfaces.rest.resources;

import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionHistoryId;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;

public record DeleteTransactionFromTransactionHistoryResource(TransactionHistoryId transactionHistoryId, TransactionId transactionId) {
}
