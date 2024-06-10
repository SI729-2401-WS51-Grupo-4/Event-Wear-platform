package com.event.wear.platform.Shipping.domain.services;

import com.event.wear.platform.Shipping.domain.model.queries.GetAllShippingHistoryByIdUser;
import java.util.List;
import java.util.Map;

public interface ShippingHistoryQueryService {
    List<Map<String, Object>> handle(GetAllShippingHistoryByIdUser query);
}