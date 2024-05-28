package com.event.wear.platform.publication.domain.services;

import com.event.wear.platform.publication.domain.model.aggregates.Publication;
import com.event.wear.platform.publication.domain.model.commands.*;

import java.util.Optional;

public interface PublicationCommandService {
    Long handle(CreatePublicationCommand command);
    Optional<Publication> handle(UpdatePublicationCommand command);
    void handle(DeletePublicationCommand command);
    void handle(AddCommentToPublicationCommand command);
    void handle(AssignLessorToPublicationCommand command);
    void handle(AddGarmentToPublication command);
}
