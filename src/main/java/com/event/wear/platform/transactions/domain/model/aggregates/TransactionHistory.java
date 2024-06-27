package com.event.wear.platform.transactions.domain.model.aggregates;

import com.event.wear.platform.shared.domain.model.entities.AuditableModel;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionHistoryId;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionList;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Represents a transaction history.
 */
@Getter
@Entity
public class TransactionHistory extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Column(name = "transactionHistory_id")
    private final TransactionHistoryId transactionHistoryId;

    private final TransactionList transactionList;

    public TransactionHistory() {
        this.transactionHistoryId = new TransactionHistoryId();
        this.transactionList = new TransactionList();
    }

    public void addTransaction(Transaction transaction) {
        transactionList.addTransaction(transaction);
        System.out.println("guardado");
    }

    public void deleteTransaction(Transaction transaction){
        transactionList.removeTransaction(transaction);
    }
}
