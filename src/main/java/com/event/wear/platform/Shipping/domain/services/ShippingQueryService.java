package com.event.wear.platform.Shipping.domain.services;

import com.event.wear.platform.Shipping.domain.model.queries.GetAllShippingsQuery;
import java.util.List;
import java.util.Map;

public interface ShippingQueryService {
    List<Map<String, Object>> handle(GetAllShippingsQuery query);
}