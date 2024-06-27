package com.event.wear.platform.transactions.domain.model.queries;

import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;

public record GetTransactionByIdQuery(TransactionId transactionid) {
}
