package com.event.wear.platform.rent.domain.services;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.model.queries.GetAllCartItemsByUserIdQuery;
import com.event.wear.platform.rent.domain.model.queries.GetAllCartItemsQuery;
import com.event.wear.platform.rent.domain.model.queries.GetShoppingCartIdByUserIdQuery;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartQueryService {
    List<CartItem> handle(GetAllCartItemsByUserIdQuery query);
    Optional<ShoppingCart> handle(GetShoppingCartIdByUserIdQuery query);
    List<CartItem> handle(GetAllCartItemsQuery query);
}