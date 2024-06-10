package com.event.wear.platform.Shipping.domain.services;

import com.event.wear.platform.Shipping.domain.model.queries.GetAllDetailsQuery;
import com.event.wear.platform.Shipping.domain.model.queries.GetDetailsByIdUser;
import java.util.List;
import java.util.Map;

public interface ShippingDetailsQueryService {
    List<Map<String, Object>> handle(GetAllDetailsQuery query);
    List<Map<String, Object>> handle(GetDetailsByIdUser query);
}