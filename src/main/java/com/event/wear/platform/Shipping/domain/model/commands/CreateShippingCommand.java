package com.event.wear.platform.Shipping.domain.model.commands;


import java.util.Date;

public record CreateShippingCommand(String address, Date deadline, Date startdate, String trackingstatus, long userid) {
}
