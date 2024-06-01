package com.event.wear.platform.rent.domain.services;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface RentQueryService {
    Optional<ShoppingCart> handle(GetUserShoppingCartQuery query);
    List<CartItem> handle(GetAllCartItemsQuery query);
    Optional<List<CartItem>> handle(GetCartItemsByUserIdQuery query);

}