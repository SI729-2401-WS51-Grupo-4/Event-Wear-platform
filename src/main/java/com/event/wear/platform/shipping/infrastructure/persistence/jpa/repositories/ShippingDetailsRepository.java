package com.event.wear.platform.shipping.infrastructure.persistence.jpa.repositories;

import com.event.wear.platform.shipping.domain.model.entities.ShippingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShippingDetailsRepository extends JpaRepository<ShippingDetails, Long> {

    List<ShippingDetails> findDetailsByShippingId(Long shippingId) ;
}
