package com.event.wear.platform.transactions.domain.services;

import com.event.wear.platform.transactions.domain.model.aggregates.TransactionAggregate;
import com.event.wear.platform.transactions.domain.model.queries.GetAllTransactionsQuery;
import com.event.wear.platform.transactions.domain.model.queries.GetTransactionDetailsQuery;

import java.util.List;

public interface TransactionQueryService {
    List<TransactionAggregate> handle(GetAllTransactionsQuery query);
    TransactionAggregate handle(GetTransactionDetailsQuery query);
}