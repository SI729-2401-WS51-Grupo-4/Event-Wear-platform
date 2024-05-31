package com.event.wear.platform.Rent.domain.model.commands;

public record UpdateCartItemCommand(Long shoppingCartId, Long cartItemId, int newQuantity) {
}