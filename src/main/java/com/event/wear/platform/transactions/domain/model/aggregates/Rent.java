package com.event.wear.platform.transactions.domain.model.aggregates;

import com.event.wear.platform.shared.domain.model.entities.AuditableModel;
import com.event.wear.platform.transactions.domain.model.valueobjects.ProductId;
import com.event.wear.platform.transactions.domain.model.valueobjects.RentId;
import com.event.wear.platform.transactions.domain.model.valueobjects.TransactionId;
import com.event.wear.platform.transactions.domain.model.valueobjects.UserId;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

/**
 * Represents a rent.
 */
@Getter
@Entity
public class Rent extends AuditableModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Column(name = "rent_id")
    private final RentId rentId;

    @Embedded
    private UserId userId;

    @Embedded
    private ProductId productId;

    @ManyToOne
    @JoinColumn(name = "transactionId")
    private Transaction transaction;

    private Date date;

    public Rent() {
        this.rentId = new RentId();
        this.userId = new UserId();
        this.productId = new ProductId();
        this.date = new Date();
    }

    public Rent(Long rentId, Long userId, Long productId,Date date){
        this.rentId = new RentId(rentId);
        this.userId = new UserId(userId);
        this.productId = new ProductId(productId);
        this.date = date;
    }
}
