package com.event.wear.platform.transactions.domain.repository;

import com.event.wear.platform.transactions.domain.model.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductItem, Long> {
}