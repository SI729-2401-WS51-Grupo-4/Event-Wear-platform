package com.event.wear.platform.transactions.application.internal.commandservices;

import com.event.wear.platform.transactions.domain.model.aggregates.Transaction;
import com.event.wear.platform.transactions.domain.model.aggregates.TransactionHistory;
import com.event.wear.platform.transactions.domain.model.commands.AddTransactionToTransactionHistoryCommand;
import com.event.wear.platform.transactions.domain.model.commands.CreateTransactionHistoryCommand;
import com.event.wear.platform.transactions.domain.model.commands.DeleteTransactionFromTransactionHistoryCommand;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;
import com.event.wear.platform.transactions.domain.services.TransactionHistoryCommandService;
import com.event.wear.platform.transactions.infrastructure.persistence.jpa.repositories.TransactionHistoryRepository;
import com.event.wear.platform.transactions.infrastructure.persistence.jpa.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransactionHistoryCommandServiceImpl implements TransactionHistoryCommandService
{
    private final TransactionHistoryRepository transactionHistoryRepository;
    private final TransactionRepository transactionRepository;

    public TransactionHistoryCommandServiceImpl(TransactionHistoryRepository transactionHistoryRepository, TransactionRepository transactionRepository){
        this.transactionHistoryRepository = transactionHistoryRepository;
        this.transactionRepository = transactionRepository;
    }

    public Long handle(CreateTransactionHistoryCommand command){
        var transactionHistory = new TransactionHistory();
        try {
            transactionHistoryRepository.save(transactionHistory);
        }catch (Exception e){
            throw new IllegalArgumentException("Error while saving transactionHistory: " + e.getMessage());
        }
        return transactionHistory.getId();
    }

    public Long handle(AddTransactionToTransactionHistoryCommand command){
        if(!transactionHistoryRepository.existsById(command.transactionHistoryId().transactionHistoryId())){
            throw new IllegalArgumentException("Transaction history does not exist");
        }

        if(!transactionRepository.existsById(command.transactionId().transactionId())){
            throw new IllegalArgumentException("Transaction does not exist");
        }
        var transaction = transactionRepository.findById(command.transactionId().transactionId());

        try {
            transactionHistoryRepository.findById(command.transactionHistoryId().transactionHistoryId()).map(transactionHistory -> {
                transactionHistory.addTransaction(transaction.get());
                transactionHistoryRepository.save(transactionHistory);
                System.out.println("Transaction added successfully");
                return transactionHistory.getId();
            });
        } catch (Exception e){
            throw new IllegalArgumentException("Error while saving transactionHistory: " + e.getMessage());
        }
        return command.transactionHistoryId().transactionHistoryId();
    }

    public boolean handle(DeleteTransactionFromTransactionHistoryCommand command){
        if(!transactionHistoryRepository.existsById(command.transactionHistoryId().transactionHistoryId())){
            throw new IllegalArgumentException("Transaction history does not exist");
        }

        if(!transactionRepository.existsById(command.transactionId().transactionId())){
            throw new IllegalArgumentException("Transaction does not exist");
        }
        var transaction = transactionRepository.findById(command.transactionId().transactionId());

        try {
            transactionHistoryRepository.findById(command.transactionHistoryId().transactionHistoryId()).map(transactionHistory -> {
               transactionHistory.deleteTransaction(transaction.get());
               transactionHistoryRepository.save(transactionHistory);
               System.out.println("Transaction deleted successfully");
               return true;
            });
        } catch (Exception e){
            throw new IllegalArgumentException("Error while saving transactionHistory: " + e.getMessage());
        }
        return false;
    }
}