package com.event.wear.platform.transactions.domain.model.valueobjects;
import jakarta.persistence.Embeddable;
import org.hibernate.Transaction;

/**
 * Value object representing the transaction id.
 */
@Embeddable
public record TransactionId(Long transactionId) {
    public TransactionId {
        if (transactionId < 0)
        {
            throw new IllegalArgumentException("transactionId cannot be negative");
        }
    }

    public TransactionId(){
        this(0L);
    }
}
