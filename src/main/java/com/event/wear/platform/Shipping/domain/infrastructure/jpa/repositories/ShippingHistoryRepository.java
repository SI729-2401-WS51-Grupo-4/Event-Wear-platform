package com.event.wear.platform.Shipping.infrastructure.jpa.repositories;

import com.event.wear.platform.Shipping.domain.model.aggregates.ShippingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingHistoryRepository extends JpaRepository<ShippingHistory, Long> {
}
