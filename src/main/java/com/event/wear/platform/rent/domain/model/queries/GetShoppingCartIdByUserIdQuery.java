package com.event.wear.platform.rent.domain.model.queries;

public record GetShoppingCartIdByUserIdQuery(Long userId) {
    public GetShoppingCartIdByUserIdQuery {
        if (userId < 0) {
            throw new IllegalArgumentException("User id cannot be negative");
        }
    }

    public GetShoppingCartIdByUserIdQuery() {
        this(0L);
    }
}
