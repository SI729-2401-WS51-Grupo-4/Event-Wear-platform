package com.event.wear.platform.publication.interfaces.rest.transform;

import com.event.wear.platform.publication.domain.model.entities.Garment;
import com.event.wear.platform.publication.interfaces.rest.resources.GarmentResource;

public class GarmentResourceFromEntityAssembler {
    public static GarmentResource toResourceFromEntity(Garment entity) {
        return new GarmentResource(
                entity.getTitle(),
                entity.getDescription(),
                entity.getSize(),
                entity.getPublication().getCost().toString()
        );
    }
}
