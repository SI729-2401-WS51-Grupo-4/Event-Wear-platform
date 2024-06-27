package com.event.wear.platform.publication.interfaces.rest.resources;

public record UpdatePublicationResource (Long publicationId, Integer cost, Long lessorId, String title, String description, String size) {
}
