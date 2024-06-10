package com.event.wear.platform.Shipping.domain.model.aggregates;

import com.event.wear.platform.Shipping.domain.model.valueobjects.RentId;
import com.event.wear.platform.Shipping.domain.model.valueobjects.UserId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class ShippingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Embedded
    @JoinColumn(name = "user_id")
    private UserId userId;

    @ElementCollection
    private Long shippingIds;


    //private List<Long> shippingIds = new ArrayList<>();


    public ShippingHistory(UserId userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId.getId();
    }

}
