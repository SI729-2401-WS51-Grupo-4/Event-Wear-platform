package com.event.wear.platform.shipping.domain.model.aggregates;

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

    //private Long shippingId;

    private String description;


    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "shipping_history_id")
    //private List<Shipping> shippings = new ArrayList<>();

    public ShippingHistory() {
    }

    public ShippingHistory(Long shippingId) {

        //this.shippings = shippings;
        //this.shippingId = shippingId;
    }

    /*
    public void addShipping(Shipping shipping) {
        shippings.add(shipping);
        shipping.setShippingHistory(this);
    }

    public void removeShipping(Shipping shipping) {
        shippings.remove(shipping);
        shipping.setShippingHistory(null);
    }
    */

    public void setDescription(String description) {
        this.description = description;
    }

    //public Long getShippingId() {
        //return this.shippingId;
    //}

}
