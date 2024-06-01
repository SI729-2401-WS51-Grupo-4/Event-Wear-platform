package com.event.wear.platform.rent.domain.model.queries;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;

public record GetAllCartItemsQuery (ShoppingCart shoppingCartId){
}
