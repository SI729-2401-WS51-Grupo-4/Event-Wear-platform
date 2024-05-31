package com.event.wear.platform.Shipping.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
@Embeddable
public record UserId(long userid) {

    public UserId {
        if (userid < 0) {
            throw new IllegalArgumentException("userid cannot be negative");
        }
    }

    public UserId() {
        this(0L);
    }

}
