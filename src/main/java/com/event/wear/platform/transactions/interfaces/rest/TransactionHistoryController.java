package com.event.wear.platform.transactions.interfaces.rest;

import com.event.wear.platform.transactions.domain.services.TransactionHistoryCommandService;
import com.event.wear.platform.transactions.domain.services.TransactionHistoryQueryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/transactionHistories", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionHistoryController {
    private final TransactionHistoryQueryService transactionHistoryQueryService;
    private final TransactionHistoryCommandService transactionHistoryCommandService;

    public TransactionHistoryController(TransactionHistoryQueryService transactionHistoryQueryService, TransactionHistoryCommandService transactionHistoryCommandService){
        this.transactionHistoryQueryService = transactionHistoryQueryService;
        this.transactionHistoryCommandService = transactionHistoryCommandService;
    }


}
