package com.event.wear.platform.transactions.domain.model.commands;

import com.event.wear.platform.transactions.domain.model.valueobjects.PaymentMethod;

import java.util.Date;

public record CreateTransactionCommand(Long userId, Long lessorId,
                                       int amount, Date date, PaymentMethod paymentMethod, String paymentDetails) {
}