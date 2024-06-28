package com.event.wear.platform.publication.interfaces.rest.transform;

import com.event.wear.platform.publication.domain.model.commands.UpdatePublicationCommand;
import com.event.wear.platform.publication.domain.model.entities.Garment;
import com.event.wear.platform.publication.domain.model.valueobjects.LessorId;
import com.event.wear.platform.publication.interfaces.rest.resources.UpdatePublicationResource;

public class UpdatePublicationCommandFromResourceAssembler {
    public static UpdatePublicationCommand toCommandFromResource(UpdatePublicationResource resource) {
        return new UpdatePublicationCommand(
                resource.publicationId(),
                resource.cost(),
                new LessorId(resource.lessorId()),
                new Garment(resource.title(), resource.description())
        );
    }
}
