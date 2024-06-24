package com.event.wear.platform.transactions.application.internal.commandservices;

import com.event.wear.platform.transactions.domain.model.aggregates.Transaction;
import com.event.wear.platform.transactions.domain.model.commands.AddRentToTransactionCommand;
import com.event.wear.platform.transactions.domain.model.commands.CreateTransactionCommand;
import com.event.wear.platform.transactions.domain.services.TransactionCommandService;
import com.event.wear.platform.transactions.infrastructure.persistence.jpa.repositories.RentRepository;
import com.event.wear.platform.transactions.infrastructure.persistence.jpa.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private final TransactionRepository transactionRepository;
    private final RentRepository rentRepository;

    public TransactionCommandServiceImpl(TransactionRepository transactionRepository, RentRepository rentRepository) {
        this.transactionRepository = transactionRepository;
        this.rentRepository = rentRepository;
    }

    @Override
    public Long handle(AddRentToTransactionCommand command){
        if(!transactionRepository.existsById(command.transactionId().transactionId())){
            throw new IllegalArgumentException("Transaction does not exists");
        }

        if(!rentRepository.existsById(command.rentId().rentId())){
            throw new IllegalArgumentException("Rent does not exists");
        }
        var rent = rentRepository.findById(command.rentId().rentId());

        try {
            transactionRepository.findById(command.transactionId().transactionId()).map(transaction -> {
                transaction.addRent(rent.get());
                transactionRepository.save(transaction);
                System.out.println("Rent added successfully");
                return transaction.getId();
            });
        } catch (Exception e){
            throw new IllegalArgumentException("Error while adding rent to transaction: " + e.getMessage());
        }
        return command.transactionId().transactionId();
    }

    @Override
    public Long handle(CreateTransactionCommand command){
        var transaction = new Transaction(command);
        try {
            transactionRepository.save(transaction);
        } catch (Exception e){
            throw new IllegalArgumentException("Eror while saving transaction: " + e.getMessage());
        }
        return transaction.getId();
    }
}