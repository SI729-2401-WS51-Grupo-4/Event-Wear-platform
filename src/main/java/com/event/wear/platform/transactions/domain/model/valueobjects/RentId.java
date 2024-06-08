package com.event.wear.platform.transactions.domain.model.valueobjects;
import jakarta.persistence.Embeddable;

/**
 * Value object representing the rent id.
 */
@Embeddable
public record RentId(Long rentId) {
    public RentId{
        if (rentId < 0)
        {
            throw new IllegalArgumentException("rentId cannot be negative");
        }
    }

    public RentId(){
        this(0L);
    }
}