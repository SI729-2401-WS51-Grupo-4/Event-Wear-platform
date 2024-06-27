package com.event.wear.platform.shipping.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record RentId(long rentid) {

    public RentId {
        if (rentid < 0) {
            throw new IllegalArgumentException("rentid cannot be negative");
        }
    }

    public RentId() {
        this(0L);
    }

    public long getRentId() {
        return this.rentid;
    }
}
