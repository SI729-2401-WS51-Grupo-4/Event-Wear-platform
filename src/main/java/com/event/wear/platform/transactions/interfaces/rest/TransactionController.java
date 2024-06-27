package com.event.wear.platform.transactions.interfaces.rest;

import com.event.wear.platform.transactions.domain.model.queries.GetAllTransactionsQuery;
import com.event.wear.platform.transactions.domain.model.queries.GetTransactionByIdQuery;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;
import com.event.wear.platform.transactions.domain.services.TransactionCommandService;
import com.event.wear.platform.transactions.domain.services.TransactionQueryService;
import com.event.wear.platform.transactions.interfaces.rest.resources.AddRentToTransactionResource;
import com.event.wear.platform.transactions.interfaces.rest.resources.CreateTransactionResource;
import com.event.wear.platform.transactions.interfaces.rest.resources.TransactionResource;
import com.event.wear.platform.transactions.interfaces.rest.transform.AddRentToTransactionCommandFromResourceAssembler;
import com.event.wear.platform.transactions.interfaces.rest.transform.CreateTransactionCommandFromResourceAssembler;
import com.event.wear.platform.transactions.interfaces.rest.transform.TransactionResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {
    private final TransactionQueryService transactionQueryService;
    private final TransactionCommandService transactionCommandService;

    public TransactionController(TransactionQueryService transactionQueryService, TransactionCommandService transactionCommandService) {
        this.transactionQueryService = transactionQueryService;
        this.transactionCommandService = transactionCommandService;
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionResource> getTransactionById(@PathVariable long transactionId) {
        var getTransactionByIdQuery = new GetTransactionByIdQuery(new TransactionId(transactionId));
        var transaction = transactionQueryService.handle(getTransactionByIdQuery);
        if(transaction.isEmpty())
            return ResponseEntity.badRequest().build();
        var transactionResource = TransactionResourceFromEntityAssembler.toResourceFromEntity(transaction.get());
        return ResponseEntity.ok(transactionResource);
    }

    @GetMapping
    public ResponseEntity<List<TransactionResource>> getAllTransaction(){
        var getAllTransactionsQuery = new GetAllTransactionsQuery();
        var transactions = transactionQueryService.handle(getAllTransactionsQuery);
        var transactionsResources = transactions.stream().map(TransactionResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(transactionsResources);
    }


    @PostMapping
    public ResponseEntity<TransactionResource> createTransaction(@RequestBody CreateTransactionResource createTransactionResource) {
        var createTransactionCommand = new CreateTransactionCommandFromResourceAssembler().toCommandFromResource(createTransactionResource);
        var transactionId = transactionCommandService.handle(createTransactionCommand);

        if (transactionId == 0L)
            return ResponseEntity.badRequest().build();

        var getTransactionByIdQuery = new GetTransactionByIdQuery(new TransactionId(transactionId));
        var transaction = transactionQueryService.handle(getTransactionByIdQuery);
        if(transaction.isEmpty())
            return ResponseEntity.badRequest().build();

        var transactionResource = TransactionResourceFromEntityAssembler.toResourceFromEntity(transaction.get());
        return new ResponseEntity<>(transactionResource, HttpStatus.CREATED);
    }

    //Quizas quizas de error
    @PutMapping("/{transactionId}")
    public ResponseEntity<TransactionResource> addRentToTransaction(@RequestBody AddRentToTransactionResource addRentToTransactionResource) {
        var addRentToTransactionCommand = AddRentToTransactionCommandFromResourceAssembler.toCommandFromResource(addRentToTransactionResource);
        var updatedTransactionId = transactionCommandService.handle(addRentToTransactionCommand);
        return getTransactionById(updatedTransactionId);
    }

}
