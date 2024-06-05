package com.event.wear.platform.transactions.domain.model.aggregates;

import com.event.wear.platform.shared.domain.model.entities.AuditableModel;
import com.event.wear.platform.transactions.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

/**
 * Represents a transaction.
 */
@Getter
@Entity
public class Transaction extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Column(name = "transaction_id")
    private final TransactionId transactionId;

    @Embedded
    private RentId rentId;

    @Embedded
    private UserId userId;

    @Embedded
    private LessorId lessorId;

    private int amount;

    private Date date;

    private PaymentMethod paymentMethod;

    private String paymentDetails;

    public Transaction() {
        this.transactionId = new TransactionId();
        this.rentId = new RentId();
        this.userId = new UserId();
        this.lessorId = new LessorId();
        this.amount = 0;
        this.date = new Date();
        this.paymentMethod = PaymentMethod.NONE;
        this.paymentDetails = "";
    }

    public Transaction(Long transactionId, Long rentId, Long userId, Long lessorId,
                       int amount, Date date, PaymentMethod paymentMethod, String paymentDetails){
        this.transactionId = new TransactionId(transactionId);
        this.rentId = new RentId(rentId);
        this.userId = new UserId(userId);
        this.lessorId = new LessorId(lessorId);
        this.amount = amount;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.paymentDetails = paymentDetails;
    }

    public String WriteDetails(){
        return "Cantidad: " + this.amount + " Fecha: " + this.date.toString() + " Metodo de pago: " + this.paymentMethod.toString() +
                " Detalles del pago: " + this.paymentDetails;
    }
}