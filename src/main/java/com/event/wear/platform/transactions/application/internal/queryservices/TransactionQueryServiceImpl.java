package com.event.wear.platform.transactions.application.internal.queryservices;

import com.event.wear.platform.transactions.domain.model.aggregates.Transaction;
import com.event.wear.platform.transactions.domain.model.queries.GetAllTransactionsQuery;
import com.event.wear.platform.transactions.domain.model.queries.GetTransactionByIdQuery;
import com.event.wear.platform.transactions.domain.services.TransactionQueryService;
import com.event.wear.platform.transactions.infrastructure.persistence.jpa.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionQueryServiceImpl implements TransactionQueryService {

    private final TransactionRepository transactionRepository;

    public TransactionQueryServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> handle(GetAllTransactionsQuery query){
        return  transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> handle(GetTransactionByIdQuery query){
        return transactionRepository.findById(query.transactionid().transactionId());
    }
}
