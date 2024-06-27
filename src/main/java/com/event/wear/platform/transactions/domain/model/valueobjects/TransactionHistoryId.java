package com.event.wear.platform.transactions.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the transaction history id.
 */
@Embeddable
public record TransactionHistoryId(Long transactionHistoryId) {
    public TransactionHistoryId {
        if(transactionHistoryId < 0)
        {
            throw new IllegalArgumentException("transactionHistoryId cannot be negative");
        }
    }

    public TransactionHistoryId(){
        this(0L);
    }
}