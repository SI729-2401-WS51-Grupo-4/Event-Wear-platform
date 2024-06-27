package com.event.wear.platform.transactions.interfaces.rest.resources;

import java.util.Date;

public record RentResource(Long Id, Long userId, Long productId, Long transactionId, Date date) {
}
