package com.event.wear.platform.Shipping.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateShippingResource(String addres, LocalDateTime deadeline, LocalDateTime starday, long rentid, long shippingdetalid, String trackingstatus,long userid) {
}
