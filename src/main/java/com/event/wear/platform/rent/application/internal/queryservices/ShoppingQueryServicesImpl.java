package com.event.wear.platform.rent.application.internal.queryservices;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.queries.*;
import com.event.wear.platform.rent.domain.services.ShoppingCartQueryService;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ShoppingQueryServicesImpl implements ShoppingCartQueryService {

    private final ShoppingCartRepository shoppingCartRepository;


    public ShoppingQueryServicesImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public Optional<ShoppingCart> handle(GetUserShoppingCartQuery query) {
        Long userId = query.userId();
        return shoppingCartRepository.findByUserId(userId)
                .stream()
                .findFirst();
    }

    @Override
   public Optional<ShoppingCart> handle(GetAllCartItemsByUserIdQuery query) {
        return shoppingCartRepository.findByUserId(query.cartId());
    }

   @Override
    public List<Map<String, Object>> handle(GetShoppingCartIdByUserIdQuery query) {
    Long userId = query.userId();
    return shoppingCartRepository.findByUserId(userId)
            .stream()
            .map(shoppingCart -> {
                Map<String, Object> shoppingCartMap = new HashMap<>();
                shoppingCartMap.put("shoppingcart_id", shoppingCart.getShoppingcart_id());
                return shoppingCartMap;
            })
            .collect(Collectors.toList());
    }

   @Override
    public List<Map<String, Object>> handle(GetAllCartItemsQuery query) {
    return shoppingCartRepository.findAll()
            .stream()
            .flatMap(shoppingCart -> shoppingCart.getItems().stream())
            .map(item -> {
                Map<String, Object> itemMap = new LinkedHashMap<>();
                itemMap.put("CarItemId", item.getId());
                itemMap.put("publicationId", item.getPublicationId());
                itemMap.put("quantity", item.getQuantity());
                itemMap.put("userId", item.getUserId());
                itemMap.put("shoppingcartId", item.getShoppingcart_id());
                return itemMap;
            })
            .collect(Collectors.toList());
}

}