package com.event.wear.platform.transactions.interfaces.rest.resources;

import com.event.wear.platform.transactions.domain.model.aggregates.Transaction;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionList;

import java.util.List;

public record TransactionHistoryResource(Long id, List<Long> transactions) {
}
