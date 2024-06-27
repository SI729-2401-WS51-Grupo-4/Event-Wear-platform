package com.event.wear.platform.shipping.domain.services;

import com.event.wear.platform.shipping.domain.model.entities.ShippingDetails;
import com.event.wear.platform.shipping.domain.model.queries.GetAllDetailsByShippingIdQuery;

import java.util.List;
import java.util.Map;

public interface ShippingDetailsQueryService {

    List<ShippingDetails> handle(GetAllDetailsByShippingIdQuery query);

}
