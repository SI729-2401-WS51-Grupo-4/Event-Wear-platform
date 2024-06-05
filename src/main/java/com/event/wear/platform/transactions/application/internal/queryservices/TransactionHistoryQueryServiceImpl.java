package com.event.wear.platform.transactions.application.internal.queryservices;

import com.event.wear.platform.transactions.domain.model.aggregates.TransactionHistory;
import com.event.wear.platform.transactions.domain.model.queries.GetTransactionHistoryByIdQuery;
import com.event.wear.platform.transactions.domain.services.TransactionHistoryQueryService;
import com.event.wear.platform.transactions.infrastructure.persistence.jpa.repositories.TransactionHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionHistoryQueryServiceImpl implements TransactionHistoryQueryService {

    private final TransactionHistoryRepository transactionHistoryRepository;

    public TransactionHistoryQueryServiceImpl(TransactionHistoryRepository transactionHistoryRepository) {
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    @Override
    public Optional<TransactionHistory> handle(GetTransactionHistoryByIdQuery query){
        return transactionHistoryRepository.findById(query.transactionHistoryId().transactionHistoryId());
    }

}