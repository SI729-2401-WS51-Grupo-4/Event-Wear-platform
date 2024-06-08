package com.event.wear.platform.transactions.application.internal.commandservices;

import com.event.wear.platform.transactions.domain.model.aggregates.TransactionHistory;
import com.event.wear.platform.transactions.domain.model.commands.AddTransactionToTransactionHistoryCommand;
import com.event.wear.platform.transactions.domain.model.commands.CreateTransactionHistoryCommand;
import com.event.wear.platform.transactions.domain.model.commands.DeleteTransactionFromTransactionHistoryCommand;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;
import com.event.wear.platform.transactions.domain.services.TransactionHistoryCommandService;
import com.event.wear.platform.transactions.infrastructure.persistence.jpa.repositories.TransactionHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransactionHistoryCommandServiceImpl implements TransactionHistoryCommandService
{
    private final TransactionHistoryRepository transactionHistoryRepository;

    public TransactionHistoryCommandServiceImpl(TransactionHistoryRepository transactionHistoryRepository){
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    public Long handle(CreateTransactionHistoryCommand command){
        if (transactionHistoryRepository.existsById(command.transactionHistoryId().transactionHistoryId())){
            throw new IllegalArgumentException("Transaction history already exists");
        }
        var transactionHistory = new TransactionHistory(command.transactionHistoryId().transactionHistoryId(), new ArrayList<TransactionId>());
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
        try {
            transactionHistoryRepository.findById(command.transactionHistoryId().transactionHistoryId()).map(transactionHistory -> {
                transactionHistory.addTransaction(command.transactionId());
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
        try {
            transactionHistoryRepository.findById(command.transactionHistoryId().transactionHistoryId()).map(transactionHistory -> {
               transactionHistory.deleteTransaction(command.transactionId());
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