package com.event.wear.platform.shipping.infrastructure.persistence.jpa.repositories;

import com.event.wear.platform.shipping.domain.model.aggregates.ShippingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingHistoryRepository extends JpaRepository<ShippingHistory, Long> {


}
