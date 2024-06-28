package com.event.wear.platform.rent.domain.model.commands;

public record AddCartItemCommand(Long cartItemId, Long userId, Long publicationId, Integer quantity, String Urlimage, String title, Double price) {

}