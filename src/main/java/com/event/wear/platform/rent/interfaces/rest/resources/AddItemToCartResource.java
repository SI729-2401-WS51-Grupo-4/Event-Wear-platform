
package com.event.wear.platform.rent.interfaces.rest.resources;

import com.event.wear.platform.rent.domain.model.valueobjects.PublicationId;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;

public record AddItemToCartResource(Long userId, Long publicationId, Long quantity) {
    public UserId getUserId() {
        return new UserId(userId);
    }

    public PublicationId getPublicationId() {
        return new PublicationId(publicationId);
    }
}