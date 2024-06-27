package com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories;

import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByUserId(UserId userId);
    List<CartItem> findAllByUserId(UserId userId);
}