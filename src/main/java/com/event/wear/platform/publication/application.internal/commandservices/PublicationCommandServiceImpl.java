package com.event.wear.platform.publication.application.internal.commandservices;

import com.event.wear.platform.publication.domain.model.aggregates.Publication;
import com.event.wear.platform.publication.domain.model.commands.*;
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
    public Long handle(CreatePublicationCommand command) {
        if (publicationRepository.existsByGarment(command.garment())) {
            throw new IllegalArgumentException("Publication already exists");
        }
        var publication = new Publication(command.cost(), command.lessorId(), command.garment(), command.comments());
        publicationRepository.save(publication);
        return publication.getId();
    }
    @Override
    public Optional<Publication> handle(UpdatePublicationCommand command){
        if (!publicationRepository.existsById(command.publicationId())) {
            throw new IllegalArgumentException("Publication does not exist");
        }
        var publication = publicationRepository.findById(command.publicationId()).get();
        publication.updateCost(command.cost());
        publication.updateLessorId(command.lessorId());
        publication.updateGarment(command.garment());
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
    public void handle(AddCommentToPublicationCommand command){
        if (!publicationRepository.existsById(command.publicationId())) {
            throw new IllegalArgumentException("Publication does not exist");
        }
        var publication = publicationRepository.findById(command.publicationId()).get();
        publication.addComment(command.comment());
        publicationRepository.save(publication);
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
    @Override
    public void handle(AddGarmentToPublication command){
        if (!publicationRepository.existsById(command.publicationId())) {
            throw new IllegalArgumentException("Publication does not exist");
        }
        var publication = publicationRepository.findById(command.publicationId()).get();
        publication.updateGarment(command.garment());
        publicationRepository.save(publication);
    }
}
