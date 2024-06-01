package com.event.wear.platform.rent.interfaces.rest.resources;

import com.event.wear.platform.rent.domain.model.valueobjects.UserId;

public record DeleteCartItemResource(UserId userId, Long cartItemId){
}
