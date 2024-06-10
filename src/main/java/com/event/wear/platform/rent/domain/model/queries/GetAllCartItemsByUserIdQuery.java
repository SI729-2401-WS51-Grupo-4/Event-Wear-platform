package com.event.wear.platform.rent.domain.model.queries;

public record GetAllCartItemsByUserIdQuery(Long cartId) {
    public GetAllCartItemsByUserIdQuery {
        if (cartId < 0) {
            throw new IllegalArgumentException("User id cannot be negative");
        }
    }
}
