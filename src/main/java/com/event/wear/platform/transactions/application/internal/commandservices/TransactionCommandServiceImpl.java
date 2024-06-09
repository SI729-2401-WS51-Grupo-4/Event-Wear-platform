package com.event.wear.platform.transactions.application.internal.commandservices;

import com.event.wear.platform.transactions.domain.model.aggregates.Transaction;
import com.event.wear.platform.transactions.domain.model.commands.AddRentToTransactionCommand;
import com.event.wear.platform.transactions.domain.model.commands.CreateTransactionCommand;
import com.event.wear.platform.transactions.domain.model.commands.UpdateTransactionCommand;
import com.event.wear.platform.transactions.domain.services.TransactionCommandService;
import com.event.wear.platform.transactions.infrastructure.persistence.jpa.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private final TransactionRepository transactionRepository;

    public TransactionCommandServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Long handle(AddRentToTransactionCommand command){
        if(!transactionRepository.existsById(command.transactionId().transactionId())){
            throw new IllegalArgumentException("Transaction does not exists");
        }

        try {
            transactionRepository.findById(command.transactionId().transactionId()).map(transaction -> {
                transaction.addRent(command.rentId());
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
        if(transactionRepository.existsById(command.transactionId())){
            throw new IllegalArgumentException("Transaction with Id alredy exists");
        }
        var transaction = new Transaction(command);
        try {
            transactionRepository.save(transaction);
        } catch (Exception e){
            throw new IllegalArgumentException("Eror while saving transaction: " + e.getMessage());
        }
        return transaction.getId();
    }

    @Override
    public Transaction handle(UpdateTransactionCommand command){
        /*var result = transactionRepository.findById(command.transactionId().transactionId());
        if (result.isEmpty()){
            throw new IllegalArgumentException("Transaction does not exists");
        }
        var transactionToUpdate = result.get();
        try {
            var updatedTransaction = transactionRepository.save(transactionToUpdate.updateInformation(
                    command.transaction().getRentId().rentId(), command.transaction().getUserId().userId(), command.transaction().getLessorId().lessorId(),
                    command.transaction().getAmount(),command.transaction().getDate(), command.transaction().getPaymentMethod(),
                    command.transaction().getPaymentDetails()));
            return Optional.of(updatedTransaction);
        } catch (Exception e){
            throw new IllegalArgumentException("Error while updating transaction: " + e.getMessage());
        }*/
        return new Transaction();
    }
}