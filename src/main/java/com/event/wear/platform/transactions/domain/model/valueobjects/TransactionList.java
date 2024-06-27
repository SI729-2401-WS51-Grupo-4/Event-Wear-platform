package com.event.wear.platform.transactions.domain.model.valueobjects;

import com.event.wear.platform.transactions.domain.model.aggregates.Transaction;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class TransactionList {

    @Getter
    private List<Long> transactions;

    public TransactionList() {
        this.transactions = new ArrayList<Long>();
    }

    public void addTransaction(Long transactionId) {
        this.transactions.add(transactionId);
    }

    public void removeTransaction(Long transactionId) {
        this.transactions.remove(transactionId);
    }
}