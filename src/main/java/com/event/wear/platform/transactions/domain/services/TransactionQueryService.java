package com.event.wear.platform.transactions.domain.services;

import com.event.wear.platform.transactions.domain.model.aggregates.Transaction;
import com.event.wear.platform.transactions.domain.model.queries.GetAllTransactionsQuery;
import com.event.wear.platform.transactions.domain.model.queries.GetTransactionByIdQuery;

import java.util.List;
import java.util.Optional;

public interface TransactionQueryService {
    List<Transaction> handle(GetAllTransactionsQuery query);
    Optional<Transaction> handle(GetTransactionByIdQuery query);
}