package com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories;
import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
   Optional<ShoppingCart> findById(ShoppingCart shoppingCartId);
   Optional<ShoppingCart> findByUserId(UserId userId);
}