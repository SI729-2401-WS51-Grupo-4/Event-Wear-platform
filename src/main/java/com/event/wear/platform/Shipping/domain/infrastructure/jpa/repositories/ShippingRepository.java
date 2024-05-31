package com.event.wear.platform.Shipping.infrastructure.jpa.repositories;

import com.event.wear.platform.Shipping.domain.model.entities.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}
