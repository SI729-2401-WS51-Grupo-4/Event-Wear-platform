package com.event.wear.platform.rent.domain.model.commands;

public record UpdateCartItemCommand(Long shoppingCartId, Long cartItemId, int newQuantity) {
}