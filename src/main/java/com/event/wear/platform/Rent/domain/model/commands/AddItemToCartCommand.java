package com.event.wear.platform.Rent.domain.model.commands;

import com.event.wear.platform.Rent.domain.model.valueobjects.PublicationId;

public record AddItemToCartCommand(Long shoppingCartId, PublicationId publicationId, int quantity) {
}