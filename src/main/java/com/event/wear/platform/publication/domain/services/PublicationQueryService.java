package com.event.wear.platform.publication.domain.services;

import com.event.wear.platform.publication.domain.model.aggregates.Publication;
import com.event.wear.platform.publication.domain.model.entities.Comment;
import com.event.wear.platform.publication.domain.model.entities.Garment;
import com.event.wear.platform.publication.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface PublicationQueryService {
    List<Publication> handle(GetAllPublicationsQuery query);
    Optional<Publication> handle(GetPublicationByIdQuery query);
    List<Publication> handle (GetPublicationByLessorIdQuery query);
    List<Comment> handle(GetAllCommentsQuery query);
    Optional<List<Comment>> handle(GetCommentsByPublicationIdQuery query);
    Optional<Garment> handle(GetGarmentByPublicationIdQuery query);
}
