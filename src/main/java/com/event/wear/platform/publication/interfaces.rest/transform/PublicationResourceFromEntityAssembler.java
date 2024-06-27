package com.event.wear.platform.publication.interfaces.rest.transform;

import com.event.wear.platform.publication.domain.model.aggregates.Publication;
import com.event.wear.platform.publication.interfaces.rest.resources.PublicationResource;

import java.util.Optional;

public class PublicationResourceFromEntityAssembler {
    public static PublicationResource toResourceFromEntity(Publication entity) {
        return new PublicationResource(
                entity.getCost(),
                entity.getLessorId().lessorId(),
                entity.getGarment().getTitle(),
                entity.getGarment().getDescription(),
                entity.getGarment().getSize()
        );
    }
}
