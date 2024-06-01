package com.event.wear.platform.rent.application.internal.queryservices;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.model.queries.*;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import com.event.wear.platform.rent.domain.services.RentQueryService;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingQueryServicesImpl implements RentQueryService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingQueryServicesImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

@Override
public Optional<ShoppingCart> handle(GetUserShoppingCartQuery query) {
    UserId userId = new UserId(query.userId());
    return shoppingCartRepository.findByUserId(userId)
            .stream()
            .findFirst();
}

    @Override
    public List<CartItem> handle(GetAllCartItemsQuery query) {
            return shoppingCartRepository.findById(query.shoppingCartId().value())
                .map(ShoppingCart::getItems)
                .orElseThrow(() -> new IllegalArgumentException("ShoppingCart not found"));
    }
    @Override
public Optional<List<CartItem>> handle(GetCartItemsByUserIdQuery query) {
    UserId userId = new UserId(query.userId());
    return shoppingCartRepository.findByUserId(userId)
            .stream()
            .map(ShoppingCart::getItems)
            .findFirst();
}
}