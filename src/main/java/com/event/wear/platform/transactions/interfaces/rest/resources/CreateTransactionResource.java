package com.event.wear.platform.transactions.interfaces.rest.resources;

import com.event.wear.platform.transactions.domain.model.valueobjects.PaymentMethod;

import java.util.Date;

public record CreateTransactionResource(Long userId, Long lessorId,
                                        int amount, Date date, PaymentMethod paymentMethod, String paymentDetails) {
}
