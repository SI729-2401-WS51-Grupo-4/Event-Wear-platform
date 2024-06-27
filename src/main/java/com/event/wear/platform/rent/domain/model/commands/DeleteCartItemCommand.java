package com.event.wear.platform.rent.domain.model.commands;

public record DeleteCartItemCommand(Long userId, Long cartItemId) {
}