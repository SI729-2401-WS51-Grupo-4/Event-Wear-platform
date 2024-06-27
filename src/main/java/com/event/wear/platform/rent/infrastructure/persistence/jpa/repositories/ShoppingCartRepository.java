package com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories;
import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findByUserId(Long userId);
}