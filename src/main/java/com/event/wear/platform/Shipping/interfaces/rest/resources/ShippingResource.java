package com.event.wear.platform.Shipping.interfaces.rest.resources;

import com.event.wear.platform.Shipping.domain.model.entities.ShippingDetails;

import java.time.LocalDateTime;

public record ShippingResource(long id , String  addres, LocalDateTime deadline, LocalDateTime starday, String TrackingStatus, String shippingDetails, long rentid) {
}
