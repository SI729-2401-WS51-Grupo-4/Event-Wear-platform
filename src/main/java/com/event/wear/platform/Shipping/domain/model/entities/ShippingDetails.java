package com.event.wear.platform.Shipping.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class ShippingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;

    @JoinColumn(name = "description")
    private String description;

    @JoinColumn(name = "importance_level")
    private String importancelevel;

}
