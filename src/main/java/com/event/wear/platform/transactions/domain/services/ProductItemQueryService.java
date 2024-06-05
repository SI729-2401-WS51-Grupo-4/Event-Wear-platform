package com.event.wear.platform.transactions.domain.services;

import com.event.wear.platform.transactions.domain.model.entities.ProductItem;
import com.event.wear.platform.transactions.domain.model.queries.GetProductItemByIdQuery;

import java.util.Optional;

public interface ProductItemQueryService {
    Optional<ProductItem> handle(GetProductItemByIdQuery query);
}
