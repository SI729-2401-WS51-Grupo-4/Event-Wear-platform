package com.event.wear.platform.transactions.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the product id.
 */
@Embeddable
public record ProductId(Long productId) {
    public ProductId {
        if (productId < 0)
        {
            throw new IllegalArgumentException("productId cannot be negative");
        }
    }

    public ProductId(){
        this(0L);
    }
}
