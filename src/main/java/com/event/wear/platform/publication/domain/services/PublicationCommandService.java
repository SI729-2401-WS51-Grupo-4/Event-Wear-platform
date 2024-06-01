package com.event.wear.platform.publication.domain.services;

import com.event.wear.platform.publication.domain.model.aggregates.Publication;
import com.event.wear.platform.publication.domain.model.commands.*;
import com.event.wear.platform.publication.domain.model.entities.Comment;

import java.util.Optional;

public interface PublicationCommandService {
    Publication handle(CreatePublicationCommand command);
    Optional<Publication> handle(UpdatePublicationCommand command);
    void handle(DeletePublicationCommand command);
    Publication handle(AddCommentToPublicationCommand command);
    void handle(AssignLessorToPublicationCommand command);
}
