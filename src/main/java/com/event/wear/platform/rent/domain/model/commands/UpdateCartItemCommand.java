package com.event.wear.platform.rent.domain.model.commands;

public record UpdateCartItemCommand(Long userId, Long cartItemId, Integer newQuantity) {
}