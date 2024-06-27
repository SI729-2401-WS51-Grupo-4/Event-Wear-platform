package com.event.wear.platform.transactions.domain.model.entities.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * GetTransactionEvent
 * <p>
 *     This event is fired when the user wants to see
 *     the details of their transaction
 * </p>
 *
 */
@Getter
public final class GetTransactionsEvent extends ApplicationEvent {

    private final long transactionId;

    public GetTransactionsEvent(Object source, Long transactionId) {
        super(source);
        this.transactionId = transactionId;
    }
}
