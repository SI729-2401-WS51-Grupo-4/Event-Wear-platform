package com.event.wear.platform.rent.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductDescription {
    private String description;

    public ProductDescription() {
    }

    public ProductDescription(String description) {
        this.description = description;
    }
}