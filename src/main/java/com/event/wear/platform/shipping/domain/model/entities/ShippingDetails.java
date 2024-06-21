package com.event.wear.platform.shipping.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.event.wear.platform.shipping.domain.model.aggregates.Shipping;

@Getter
@Setter
@Entity
public class ShippingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "description")
    private String description;

    @JoinColumn(name = "importance_level")
    private String importancelevel;

    // de mi llave foranea que se creaba en la base de datos, ahora con el column
    @Column(name = "shipping_id")
    private Long shippingId;

    //@ManyToOne
    //@JoinColumn(name = "shipping_id")
    //private Shipping shipping;
    public ShippingDetails() {
    }

    public ShippingDetails(String description, String importancelevel) {
        this.description = description;
        this.importancelevel = importancelevel;
    }

}