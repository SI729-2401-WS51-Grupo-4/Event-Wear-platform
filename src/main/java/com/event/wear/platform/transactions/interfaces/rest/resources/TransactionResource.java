package com.event.wear.platform.transactions.interfaces.rest.resources;

import com.event.wear.platform.transactions.domain.model.aggregates.Rent;
import com.event.wear.platform.transactions.domain.model.valueobjects.PaymentMethod;

import java.util.Date;
import java.util.List;

public record TransactionResource(Long Id, Long userId, Long lessorId,
                                  int amount, Date date, PaymentMethod paymentMethod, String paymentDetails) {
}
