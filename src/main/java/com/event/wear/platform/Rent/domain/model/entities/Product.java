package com.event.wear.platform.Rent.domain.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.event.wear.platform.Rent.domain.model.valueobjects.ProductDescription;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private ProductDescription description;
    private double rentalPrice;

    // Constructor, getters, setters, and other methods as needed

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(ProductDescription description) {
        this.description = description;
    }

    public ProductDescription getDescription() {
        return this.description;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public double getRentalPrice() {
        return this.rentalPrice;
    }
}