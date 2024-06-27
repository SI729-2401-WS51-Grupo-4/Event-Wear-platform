package com.event.wear.platform.shipping.domain.services;


import com.event.wear.platform.shipping.domain.model.aggregates.Shipping;
import com.event.wear.platform.shipping.domain.model.entities.ShippingDetails;
import com.event.wear.platform.shipping.domain.model.queries.GetAllShippingsByHistoryIdQuery;
import com.event.wear.platform.shipping.domain.model.queries.GetAllShippingsQuery;

import java.util.List;
import java.util.Map;

public interface ShippingQueryService {
    List<Map<String, Object>> handle(GetAllShippingsQuery query);

    List<Shipping> handle(GetAllShippingsByHistoryIdQuery query);

}
