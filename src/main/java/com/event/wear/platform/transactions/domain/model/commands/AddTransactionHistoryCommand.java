package com.event.wear.platform.transactions.domain.model.commands;

import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionHistoryId;

public record AddTransactionHistoryCommand(TransactionHistoryId transactionHistoryId){
}
