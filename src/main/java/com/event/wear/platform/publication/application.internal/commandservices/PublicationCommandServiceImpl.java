package com.event.wear.platform.publication.application.internal.commandservices;

import com.event.wear.platform.publication.domain.model.aggregates.Publication;
import com.event.wear.platform.publication.domain.model.commands.*;
import com.event.wear.platform.publication.domain.model.entities.Comment;
import com.event.wear.platform.publication.domain.model.entities.Garment;
import com.event.wear.platform.publication.domain.model.valueobjects.LessorId;
import com.event.wear.platform.publication.domain.services.PublicationCommandService;
import com.event.wear.platform.publication.infrastructure.persistence.jpa.repositories.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublicationCommandServiceImpl implements PublicationCommandService {
    private final PublicationRepository publicationRepository;
    public PublicationCommandServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
    @Override
    public Publication handle(CreatePublicationCommand command) {
        if (publicationRepository.existsByGarmentTitle(command.title())) {
            throw new IllegalArgumentException("Publication already exists");
        }
        var garment = new Garment(command.title(), command.description());
        var publication = new Publication(command.price(), new LessorId(command.userId()), garment, command.image());
        publicationRepository.save(publication);
        return publication;
    }
    @Override
    public Optional<Publication> handle(UpdatePublicationCommand command){
        if (!publicationRepository.existsById(command.publicationId())) {
            throw new IllegalArgumentException("Publication does not exist");
        }
        var publication = publicationRepository.findById(command.publicationId()).get();
        publication.updateCost(command.cost());
        publication.updateLessorId(command.lessorId());
        var garment = publication.getGarment();
        garment.setTitle(command.garment().getTitle());
        garment.setDescription(command.garment().getDescription());
        garment.setSize(command.garment().getSize());
        publicationRepository.save(publication);
        return Optional.of(publication);
    }
    @Override
    public void handle(DeletePublicationCommand command){
        if (!publicationRepository.existsById(command.publicationId())) {
            throw new IllegalArgumentException("Publication does not exist");
        }
        publicationRepository.deleteById(command.publicationId());
    }
    @Override
    public Publication handle(AddCommentToPublicationCommand command){
        if (!publicationRepository.existsById(command.publicationId())) {
            throw new IllegalArgumentException("Publication does not exist");
        }
        var publication = publicationRepository.findById(command.publicationId()).get();
        var comment = publication.getComments();
        comment.add(new Comment(publication, command.content(), command.rating()));
        publicationRepository.save(publication);
        return publication;
    }
    @Override
    public void handle(AssignLessorToPublicationCommand command){
        if (!publicationRepository.existsById(command.publicationId())) {
            throw new IllegalArgumentException("Publication does not exist");
        }
        var publication = publicationRepository.findById(command.publicationId()).get();
        publication.updateLessorId(command.lessorId());
        publicationRepository.save(publication);
    }
}
