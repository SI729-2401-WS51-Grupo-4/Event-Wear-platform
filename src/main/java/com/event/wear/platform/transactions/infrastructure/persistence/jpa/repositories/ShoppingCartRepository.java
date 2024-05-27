package com.event.wear.platform.transactions.infrastructure.persistence.jpa.repositories;

import com.event.wear.platform.transactions.domain.model.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}