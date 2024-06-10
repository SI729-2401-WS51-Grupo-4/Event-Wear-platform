package com.event.wear.platform.Shipping.domain.model.commands;


import java.time.LocalDateTime;
import java.util.Date;

public record CreateShippingCommand(String address, LocalDateTime deadline, LocalDateTime startdate, long rentid, long shippingdetalid,String trackingstatus, long userid) {
}
