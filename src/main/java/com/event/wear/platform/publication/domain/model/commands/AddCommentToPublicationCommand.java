package com.event.wear.platform.publication.domain.model.commands;

import com.event.wear.platform.publication.domain.model.entities.Comment;
import com.event.wear.platform.publication.domain.model.valueobjects.UserId;

public record AddCommentToPublicationCommand (Long publicationId, Comment comment){
}
