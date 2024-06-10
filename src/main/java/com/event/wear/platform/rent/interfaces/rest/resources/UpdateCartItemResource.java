package com.event.wear.platform.rent.interfaces.rest.resources;

public record UpdateCartItemResource(Long userId, Long Id, int newQuantity) {

}
