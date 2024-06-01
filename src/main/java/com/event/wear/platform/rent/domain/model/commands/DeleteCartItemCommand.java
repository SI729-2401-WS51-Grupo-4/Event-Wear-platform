package com.event.wear.platform.rent.domain.model.commands;

import com.event.wear.platform.rent.domain.model.valueobjects.UserId;

public record DeleteCartItemCommand(UserId userId, Long cartItemId) {

}