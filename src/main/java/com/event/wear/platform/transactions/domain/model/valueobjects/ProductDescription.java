package com.event.wear.platform.transactions.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductDescription {
    private String description;

    public ProductDescription() {
        description = "";
    }

    public ProductDescription(String description) {
        this.description = description;
    }
}