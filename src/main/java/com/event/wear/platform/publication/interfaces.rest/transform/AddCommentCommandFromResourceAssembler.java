package com.event.wear.platform.publication.interfaces.rest.transform;

import com.event.wear.platform.publication.domain.model.commands.AddCommentToPublicationCommand;
import com.event.wear.platform.publication.interfaces.rest.resources.AddCommentToPublicationResource;

public class AddCommentCommandFromResourceAssembler {
    public static AddCommentToPublicationCommand toCommandFromResource(AddCommentToPublicationResource resource) {
        return new AddCommentToPublicationCommand(
                resource.publicationId(),
                resource.content(),
                resource.rating()
        );
    }
}
