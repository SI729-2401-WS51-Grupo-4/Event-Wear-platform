package com.event.wear.platform.Rent.domain.repository;

import com.event.wear.platform.Rent.domain.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}