package com.event.wear.platform.Rent.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductDescription {
    private String description;

    public ProductDescription() {
    }

    public ProductDescription(String description) {
        this.description = description;
    }

    // getters, setters, and other methods as needed
}