package com.event.wear.platform.rent.domain.model.queries;

public record GetAllCartItemsByUserIdQuery(Long userId) {
    public GetAllCartItemsByUserIdQuery {
        if (userId < 0) {
            throw new IllegalArgumentException("User id cannot be negative");
        }
    }
}
