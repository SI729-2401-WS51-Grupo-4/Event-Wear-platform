package com.event.wear.platform.transactions.domain.repository;

import com.event.wear.platform.transactions.domain.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}