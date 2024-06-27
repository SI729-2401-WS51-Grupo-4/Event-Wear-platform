package com.event.wear.platform.shipping.domain.model.valueobjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public record RemainingDays(long days) {
    public RemainingDays {
        if (days < 0) {
            throw new IllegalArgumentException("Remaining days cannot be negative");
        }
    }

    public RemainingDays calculate(LocalDate startline, LocalDate deadline) {
        long days = ChronoUnit.DAYS.between(startline, deadline);
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
