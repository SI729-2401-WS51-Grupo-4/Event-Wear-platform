package com.event.wear.platform.rent.application.internal.queryservices;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.model.queries.GetAllCartItemsByUserIdQuery;
import com.event.wear.platform.rent.domain.model.queries.GetAllCartItemsQuery;
import com.event.wear.platform.rent.domain.model.queries.GetShoppingCartIdByUserIdQuery;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import com.event.wear.platform.rent.domain.services.ShoppingCartQueryService;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.CartItemRepository;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingQueryServicesImpl implements ShoppingCartQueryService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;

    public ShoppingQueryServicesImpl(ShoppingCartRepository shoppingCartRepository, CartItemRepository cartItemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public List<CartItem> handle(GetAllCartItemsQuery query) {
        return cartItemRepository.findAll();
    }

    @Override
        public List<CartItem> handle(GetAllCartItemsByUserIdQuery query) {
        var userId = new UserId(query.userId());
        List<CartItem> cartItems = cartItemRepository.findAllByUserId(userId);
        if (cartItems == null) {
            return new ArrayList<CartItem>();
        }
        return cartItems;
    }

    @Override
    public Optional<ShoppingCart> handle(GetShoppingCartIdByUserIdQuery query) {
        return shoppingCartRepository.findById(query.userId());

    }

}