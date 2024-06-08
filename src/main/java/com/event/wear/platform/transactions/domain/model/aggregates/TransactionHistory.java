package com.event.wear.platform.transactions.domain.model.aggregates;

import com.event.wear.platform.shared.domain.model.entities.AuditableModel;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionHistoryId;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
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

    private List<TransactionId> transactionsId;

    public TransactionHistory() {
        this.transactionHistoryId = new TransactionHistoryId();
        this.transactionsId = new ArrayList<TransactionId>();
    }

    public TransactionHistory(Long transactionHistoryId, List<TransactionId> transactionsId) {
        this.transactionHistoryId = new TransactionHistoryId(transactionHistoryId);
        this.transactionsId = transactionsId;
    }

    public void addTransaction(TransactionId transactionId) {
        transactionsId.add(transactionId);
    }

    public void deleteTransaction(TransactionId transactionId){
        transactionsId.remove(new Transaction());
    }
}
