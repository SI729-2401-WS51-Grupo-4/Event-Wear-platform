package com.event.wear.platform.transactions.domain.model.valueobjects;

import com.event.wear.platform.transactions.domain.model.aggregates.Transaction;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class TransactionList {

    @OneToMany(mappedBy = "transactionHistoryId", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public TransactionList() {
        this.transactions = new ArrayList<Transaction>();
    }

    public void addTransaction(Transaction transaction) {
        System.out.println(transaction.WriteDetails());
        this.transactions.add(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        this.transactions.remove(transaction);
    }
}