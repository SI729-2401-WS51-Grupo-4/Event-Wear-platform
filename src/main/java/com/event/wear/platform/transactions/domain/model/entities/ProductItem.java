package com.event.wear.platform.transactions.domain.model.entities;

import com.event.wear.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class ProductItem extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private double rentalPrice;

    // Constructor, getters, setters, and other methods as needed
    public ProductItem() {
        name = "";
        description = "";
        rentalPrice = 0;
    }

    public ProductItem(String name, String description, double rentalPrice) {
        this.name = name;
        this.description = description;
        this.rentalPrice = rentalPrice;
    }
}