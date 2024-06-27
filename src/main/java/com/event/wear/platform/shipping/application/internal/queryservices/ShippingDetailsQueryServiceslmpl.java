package com.event.wear.platform.shipping.application.internal.queryservices;

import com.event.wear.platform.shipping.domain.model.entities.ShippingDetails;
import com.event.wear.platform.shipping.domain.model.queries.GetAllDetailsByShippingIdQuery;
import com.event.wear.platform.shipping.domain.services.ShippingDetailsQueryService;
import com.event.wear.platform.shipping.infrastructure.persistence.jpa.repositories.ShippingDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShippingDetailsQueryServiceslmpl implements ShippingDetailsQueryService {

    private final ShippingDetailsRepository shippingDetailsRepository;

    public ShippingDetailsQueryServiceslmpl(ShippingDetailsRepository shippingDetailsRepository) {
        this.shippingDetailsRepository = shippingDetailsRepository;
    }

    @Override
    public List<ShippingDetails> handle(GetAllDetailsByShippingIdQuery query) {
        return shippingDetailsRepository.findDetailsByShippingId(query.shippingId());
    }


}
