package com.event.wear.platform.publication.interfaces.rest.resources;

public record CreatePublicationResource(Integer cost, Long lessorId, String title, String description, String image) {
}
