package com.event.wear.platform.publication.application.internal.queryservices;

import com.event.wear.platform.publication.domain.model.aggregates.Publication;
import com.event.wear.platform.publication.domain.model.entities.Comment;
import com.event.wear.platform.publication.domain.model.entities.Garment;
import com.event.wear.platform.publication.domain.model.queries.*;
import com.event.wear.platform.publication.domain.services.PublicationQueryService;
import com.event.wear.platform.publication.infrastructure.persistence.jpa.repositories.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublicationQueryServiceImpl implements PublicationQueryService {
    private final PublicationRepository publicationRepository;
    public PublicationQueryServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
    @Override
    public List<Publication> handle(GetAllPublicationsQuery query) {
        return publicationRepository.findAll();
    }

    @Override
    public Optional<Publication> handle(GetPublicationByIdQuery query) {
        return publicationRepository.findById(query.publicationId());
    }

    @Override
    public List<Publication> handle(GetPublicationByLessorIdQuery query) {
        return publicationRepository.findByLessorId(query.lessorId());
    }

    @Override
    public List<Comment> handle(GetAllCommentsQuery query) {
        return publicationRepository.findAll().stream()
                .flatMap(publication -> publication.getComments().stream())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<List<Comment>> handle(GetCommentsByPublicationIdQuery query) {
        return publicationRepository.findById(query.publicationId())
                .map(publication -> publication.getComments());
    }

    @Override
    public Optional<Garment> handle(GetGarmentByPublicationIdQuery query) {
        return publicationRepository.findById(query.publicationId()).map(Publication::getGarment);
    }
}
