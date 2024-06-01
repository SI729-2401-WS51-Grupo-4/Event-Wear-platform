package com.event.wear.platform.rent.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UserId(Long userId) {
    public UserId(Integer userId) {
        this(userId.longValue());
    }

    public Long value() {
        return userId;
    }
}