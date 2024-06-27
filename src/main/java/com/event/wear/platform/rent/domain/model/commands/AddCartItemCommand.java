package com.event.wear.platform.rent.domain.model.commands;


public record AddCartItemCommand(Long userId, Long shoppingCartId, Long publicationId, Long quantity) {
    public int getQuantity() {
        return quantity.intValue();
    }
}