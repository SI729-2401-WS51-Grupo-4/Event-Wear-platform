package com.event.wear.platform.publication.interfaces.rest.transform;

import com.event.wear.platform.publication.domain.model.entities.Comment;
import com.event.wear.platform.publication.interfaces.rest.resources.CommentResource;

public class CommentResourceFromEntityAssembler {
    public static CommentResource toResourceFromEntity(Comment entity) {
        return new CommentResource(
                entity.getPublication().getId(),
                entity.getContent(),
                entity.getRating()
        );
    }
}
