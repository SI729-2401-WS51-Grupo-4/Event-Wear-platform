package com.event.wear.platform.Rent.infrastructure.persistence.jpa.repositories;

import com.event.wear.platform.Rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.Rent.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findByUserId(UserId userId);
}