
package com.event.wear.platform.rent.interfaces.rest.resources;

public record AddItemToCartResource(Long cartItemId,Long publicationId, Integer quantity, String Urlimage, String title, Double price) {
}