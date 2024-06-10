package com.event.wear.platform.rent.domain.model.commands;


public record AddCartItemCommand(Long userId, Long publicationId, Long quantity) {
}