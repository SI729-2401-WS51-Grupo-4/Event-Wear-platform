package com.event.wear.platform.rent.interfaces.rest.resources;

import com.event.wear.platform.rent.domain.model.valueobjects.UserId;

public record UpdateCartItemResource(Long userId, Long cartItemId, int newQuantity) {
    public UserId getUserId() {
        return new UserId(userId);
    }

}
