package com.event.wear.platform.transactions.domain.services;

import com.event.wear.platform.transactions.domain.model.aggregates.TransactionHistory;
import com.event.wear.platform.transactions.domain.model.queries.GetTransactionHistoryByIdQuery;

import java.util.Optional;

public interface TransactionHistoryQueryService {
    Optional<TransactionHistory> handle(GetTransactionHistoryByIdQuery query);
}