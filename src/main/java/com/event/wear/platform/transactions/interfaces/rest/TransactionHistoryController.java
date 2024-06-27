package com.event.wear.platform.transactions.interfaces.rest;

import com.event.wear.platform.transactions.domain.model.queries.GetAllTransactionHistoriesQuery;
import com.event.wear.platform.transactions.domain.model.queries.GetTransactionHistoryByIdQuery;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionHistoryId;
import com.event.wear.platform.transactions.domain.services.TransactionHistoryCommandService;
import com.event.wear.platform.transactions.domain.services.TransactionHistoryQueryService;
import com.event.wear.platform.transactions.interfaces.rest.resources.AddTransactionToTransactionHistoryResource;
import com.event.wear.platform.transactions.interfaces.rest.resources.CreateTransactionHistoryResource;
import com.event.wear.platform.transactions.interfaces.rest.resources.TransactionHistoryResource;
import com.event.wear.platform.transactions.interfaces.rest.transform.AddRentToTransactionCommandFromResourceAssembler;
import com.event.wear.platform.transactions.interfaces.rest.transform.AddTransactionToTransactionHistoryCommandFromResourceAssembler;
import com.event.wear.platform.transactions.interfaces.rest.transform.CreateTransactionHistoryCommandFromResourceAssembler;
import com.event.wear.platform.transactions.interfaces.rest.transform.TransactionHistoryResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/transactionHistories", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionHistoryController {
    private final TransactionHistoryQueryService transactionHistoryQueryService;
    private final TransactionHistoryCommandService transactionHistoryCommandService;

    public TransactionHistoryController(TransactionHistoryQueryService transactionHistoryQueryService, TransactionHistoryCommandService transactionHistoryCommandService){
        this.transactionHistoryQueryService = transactionHistoryQueryService;
        this.transactionHistoryCommandService = transactionHistoryCommandService;
    }

    @GetMapping("/{transactionHistoryId}")
    public ResponseEntity<TransactionHistoryResource> getTransactionHistoryById(@PathVariable long transactionHistoryId){
        var getTransactionHistoryByIdQuery = new GetTransactionHistoryByIdQuery(new TransactionHistoryId(transactionHistoryId));
        var transactionHistory = transactionHistoryQueryService.handle(getTransactionHistoryByIdQuery);

        if(transactionHistory.isEmpty())
            return ResponseEntity.badRequest().build();
        var transactionHistoryResource = TransactionHistoryResourceFromEntityAssembler.toResourceFromEntity(transactionHistory.get());
        return ResponseEntity.ok(transactionHistoryResource);
    }

    @GetMapping
    public ResponseEntity<List<TransactionHistoryResource>> getTransactionHistories(){
        var getAllTransactionHistoriesQuery = new GetAllTransactionHistoriesQuery();
        var histories = transactionHistoryQueryService.handle(getAllTransactionHistoriesQuery);
        var historiesResource = histories.stream().map(TransactionHistoryResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(historiesResource);
    }

    @PostMapping
    public ResponseEntity<TransactionHistoryResource> createTransactionHistory(@RequestBody CreateTransactionHistoryResource createTransactionHistoryResource){
        var createTransactionHistoryCommand = CreateTransactionHistoryCommandFromResourceAssembler.toCommandFromResource(createTransactionHistoryResource);
        var transactionhistoryId = transactionHistoryCommandService.handle(createTransactionHistoryCommand);

        if(transactionhistoryId == 0L)
            return ResponseEntity.badRequest().build();

        var getTransactionHistoryByIdQuery = new GetTransactionHistoryByIdQuery(new TransactionHistoryId(transactionhistoryId));
        var transactionHistory = transactionHistoryQueryService.handle(getTransactionHistoryByIdQuery);
        if(transactionHistory.isEmpty())
            return ResponseEntity.badRequest().build();

        var transactionHistoryResource = TransactionHistoryResourceFromEntityAssembler.toResourceFromEntity(transactionHistory.get());
        return new ResponseEntity<>(transactionHistoryResource, HttpStatus.CREATED);
    }

    @PutMapping("/{transactionistoryId}")
    public ResponseEntity<TransactionHistoryResource> addTransactionToTransactionHistory(
            @RequestBody AddTransactionToTransactionHistoryResource addTransactionToTransactionHistoryResource){
        var command = AddTransactionToTransactionHistoryCommandFromResourceAssembler.toCommandFromResource(
                addTransactionToTransactionHistoryResource);
        System.out.println("A1");
        var transactionHistory = transactionHistoryCommandService.handle(command);
        System.out.println("A2132");
        return getTransactionHistoryById(transactionHistory);
    }
}
