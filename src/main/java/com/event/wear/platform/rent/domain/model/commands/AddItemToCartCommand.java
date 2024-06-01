package com.event.wear.platform.rent.domain.model.commands;

import com.event.wear.platform.rent.domain.model.valueobjects.PublicationId;

public record AddItemToCartCommand(Long shoppingCartId, PublicationId publicationId, int quantity) {
}