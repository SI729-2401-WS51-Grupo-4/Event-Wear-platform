package com.event.wear.platform.rent.interfaces.rest.resources;

public record CartItemResource(Long cartItemId, Long Id, Long publicationId, Integer quantity, String Urlimage, String title, Double price){}

