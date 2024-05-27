package com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories;

import com.event.wear.platform.rent.domain.model.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}