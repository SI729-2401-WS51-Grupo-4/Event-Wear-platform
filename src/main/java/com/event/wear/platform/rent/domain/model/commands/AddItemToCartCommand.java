package com.event.wear.platform.rent.domain.model.commands;
import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.valueobjects.PublicationId;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;


public record AddItemToCartCommand(UserId userId, ShoppingCart shoppingCartId, PublicationId publicationId, int quantity) {
}