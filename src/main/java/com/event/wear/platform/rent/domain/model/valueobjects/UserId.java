package com.event.wear.platform.rent.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UserId(Long userId) {
    public UserId value() {
        return null;
    }
}