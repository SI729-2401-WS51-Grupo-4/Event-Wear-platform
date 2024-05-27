package com.event.wear.platform.transactions.domain.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public final class GetTransactionsEvent extends ApplicationEvent {

    public GetTransactionsEvent(Object source) {
        super(source);
    }
}
