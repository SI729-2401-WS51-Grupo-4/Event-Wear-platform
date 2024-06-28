package com.event.wear.platform.publication.interfaces.rest.transform;

import com.event.wear.platform.publication.domain.model.commands.CreatePublicationCommand;
import com.event.wear.platform.publication.domain.model.entities.Garment;
import com.event.wear.platform.publication.domain.model.valueobjects.LessorId;
import com.event.wear.platform.publication.interfaces.rest.resources.CreatePublicationResource;

public class CreatePublicationCommandFromResourceAssembler {
    public static CreatePublicationCommand toCommandFromResource(CreatePublicationResource resource) {
        return new CreatePublicationCommand(
                resource.lessorId(),
                resource.image(),
                resource.title(),
                resource.description(),
                resource.cost()
        );
    }
}