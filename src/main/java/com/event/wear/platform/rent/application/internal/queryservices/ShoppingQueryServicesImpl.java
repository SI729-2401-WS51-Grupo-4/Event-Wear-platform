package com.event.wear.platform.rent.application.internal.queryservices;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.queries.*;
import com.event.wear.platform.rent.domain.services.RentQueryService;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingQueryServicesImpl implements RentQueryService {

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
   public List<Map<String, Object>> handle(GetAllCartItemsByUserIdQuery query) {
    Long userId = query.userId();
    return shoppingCartRepository.findByUserId(userId)
            .stream()
            .flatMap(shoppingCart -> shoppingCart.getItems().stream())
            .map(item -> {
                Map<String, Object> itemMap = new HashMap<>();
                itemMap.put("publicationId", item.getPublicationId().value());
                itemMap.put("quantity", item.getQuantity());
                return itemMap;
            })
            .collect(Collectors.toList()).reversed();
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


}