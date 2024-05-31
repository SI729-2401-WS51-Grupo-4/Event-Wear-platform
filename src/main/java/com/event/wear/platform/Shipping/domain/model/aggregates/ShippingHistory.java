package com.event.wear.platform.Shipping.domain.model.aggregates;

import com.event.wear.platform.Shipping.domain.model.entities.Shipping;
import com.event.wear.platform.Shipping.domain.model.valueobjects.UserId;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ShippingHistory {

    @Embedded
    private UserId userId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "shipping_history_id")
    private List<Shipping> shippings = new ArrayList<>();

    public ShippingHistory(UserId userId) {
        this.userId = userId;
    }

}
