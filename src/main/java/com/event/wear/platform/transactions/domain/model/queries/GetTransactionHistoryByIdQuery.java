package com.event.wear.platform.transactions.domain.model.queries;

import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionHistoryId;

public record GetTransactionHistoryByIdQuery(TransactionHistoryId transactionHistoryId) {
}