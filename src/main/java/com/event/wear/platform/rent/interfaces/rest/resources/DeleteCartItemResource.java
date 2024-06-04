package com.event.wear.platform.rent.interfaces.rest.resources;

import com.event.wear.platform.rent.domain.model.valueobjects.UserId;

public record DeleteCartItemResource(Long userId, Long cartItemId) {

    public UserId getUserId() {
        return new UserId(userId);
    }
}
