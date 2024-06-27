package com.event.wear.platform.publication.interfaces.rest.resources;

public record AddCommentToPublicationResource(Long publicationId,  String content, Short rating) {
}
