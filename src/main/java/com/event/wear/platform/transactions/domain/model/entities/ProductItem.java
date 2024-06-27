package com.event.wear.platform.transactions.domain.model.entities;

import com.event.wear.platform.shared.domain.model.entities.AuditableModel;
import com.event.wear.platform.transactions.domain.model.valueobjects.ProductId;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class ProductItem extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Column(name = "product_id")
    private final ProductId productId;

    private String name;

    private String description;

    private double rentalPrice;

    // Constructor, getters, setters, and other methods as needed
    public ProductItem() {
        this.productId = new ProductId();
        name = "";
        description = "";
        rentalPrice = 0;
    }

    public ProductItem(Long productId,String name, String description, double rentalPrice) {
        this.productId = new ProductId(productId);
        this.name = name;
        this.description = description;
        this.rentalPrice = rentalPrice;
    }
}