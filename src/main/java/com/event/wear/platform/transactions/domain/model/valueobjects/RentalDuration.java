package com.event.wear.platform.transactions.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class RentalDuration {
    private int days;

    public RentalDuration() {
        days = 0;
    }

    public RentalDuration(int days) {
        this.days = days;
    }
}
