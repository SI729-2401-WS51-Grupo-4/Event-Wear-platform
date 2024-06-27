package com.event.wear.platform.shipping.domain.model.valueobjects;

import java.time.Duration;
import java.time.LocalDateTime;

public record RemainingDays(long days) {
    public RemainingDays {
        if (days < 0) {
            throw new IllegalArgumentException("Remaining days cannot be negative");
        }
    }

    public RemainingDays calculate(LocalDateTime startline, LocalDateTime deadline) {
        long days = Duration.between(startline, deadline).toDays();
        return new RemainingDays(days);
    }

    @Override
    public String toString() {
        return String.valueOf(days);
    }

    public long getDays() {
        return this.days;
    }
}
