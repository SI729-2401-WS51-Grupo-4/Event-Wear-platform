package com.event.wear.platform.rent.domain.services;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.queries.GetAllCartItemsByUserIdQuery;
import com.event.wear.platform.rent.domain.model.queries.GetAllCartItemsQuery;
import com.event.wear.platform.rent.domain.model.queries.GetShoppingCartIdByUserIdQuery;
import com.event.wear.platform.rent.domain.model.queries.GetUserShoppingCartQuery;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ShoppingCartQueryService {
    Optional<ShoppingCart> handle(GetUserShoppingCartQuery query);
    List<Map<String, Object>> handle(GetAllCartItemsByUserIdQuery query);
    List<Map<String, Object>> handle(GetShoppingCartIdByUserIdQuery query);
    List<Map<String, Object>> handle(GetAllCartItemsQuery query);
}