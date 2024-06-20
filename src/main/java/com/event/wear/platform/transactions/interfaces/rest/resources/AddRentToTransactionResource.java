package com.event.wear.platform.transactions.interfaces.rest.resources;

import com.event.wear.platform.transactions.domain.model.valueobjects.RentId;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;

public record AddRentToTransactionResource(RentId rentId, TransactionId transactionId) {
}
