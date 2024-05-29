package com.event.wear.platform.transactions.domain.model.aggregates;

import com.event.wear.platform.shared.domain.model.entities.AuditableModel;
import com.event.wear.platform.transactions.domain.model.entities.ProductItem;
import com.event.wear.platform.transactions.domain.model.valueobjects.LessorId;
import com.event.wear.platform.transactions.domain.model.valueobjects.PaymentMethod;
import com.event.wear.platform.transactions.domain.model.valueobjects.RentId;
import com.event.wear.platform.transactions.domain.model.valueobjects.UserId;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

/**
 * Represents a rent.
 */
@Entity
public class RentAggregate extends AuditableModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Embedded
    @Column(name = "rent_id")
    private final RentId rentId;

    @Getter
    @Embedded
    private UserId userId;

    @Getter
    private Date date;

    public RentAggregate() {
        this.rentId = new RentId();
        this.userId = new UserId();
        this.date = new Date();
    }

    public RentAggregate(Long rentId, Long userId, Date date){
        this.rentId = new RentId(rentId);
        this.userId = new UserId(userId);
        this.date = date;
    }
}
