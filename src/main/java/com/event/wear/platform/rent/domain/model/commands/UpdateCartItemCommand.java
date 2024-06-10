package com.event.wear.platform.rent.domain.model.commands;

public record UpdateCartItemCommand(Long userId, Long Id, int newQuantity) {
    public Object getCartItemId() {
        return Id;
    }
}