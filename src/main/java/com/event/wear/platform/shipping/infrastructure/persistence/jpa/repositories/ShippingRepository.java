package com.event.wear.platform.shipping.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.event.wear.platform.shipping.domain.model.aggregates.Shipping;

import java.util.List;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
    List<Shipping> findAll();
    List<Shipping> findShippingByShippingHistory_Id(Long shippingHistoryId);
}
