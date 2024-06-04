package com.event.wear.platform.rent.domain.model.commands;


public record AddItemToCartCommand(Long userId, Long shoppingCartId, Long publicationId, Long quantity) {
    public int getQuantity() {
        return quantity.intValue();
    }
}