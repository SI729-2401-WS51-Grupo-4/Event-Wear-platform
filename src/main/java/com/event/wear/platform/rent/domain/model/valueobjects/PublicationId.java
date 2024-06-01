package com.event.wear.platform.rent.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PublicationId(Long publicationId) {
    public PublicationId(Integer publicationId) {
        this(publicationId.longValue());
    }
}