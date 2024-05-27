package com.event.wear.platform.rent.domain.model.events;

import com.event.wear.platform.rent.domain.model.entities.User;
import com.event.wear.platform.rent.domain.model.entities.Product;
import com.event.wear.platform.rent.domain.model.valueobjects.RentalDuration;

import java.time.LocalDateTime;

public class RentalEvent {
    private User user;
    private Product product;
    private RentalDuration rentalDuration;
    private LocalDateTime rentalDate;
}
