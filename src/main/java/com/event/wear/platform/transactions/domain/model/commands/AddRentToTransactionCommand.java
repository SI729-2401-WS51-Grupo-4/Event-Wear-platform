package com.event.wear.platform.transactions.domain.model.commands;

import com.event.wear.platform.transactions.domain.model.valueobjects.RentId;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;

public record AddRentToTransactionCommand(RentId rentId, TransactionId transactionId) {
}
