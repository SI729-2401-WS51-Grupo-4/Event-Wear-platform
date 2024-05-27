package com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories;

import com.event.wear.platform.rent.domain.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}