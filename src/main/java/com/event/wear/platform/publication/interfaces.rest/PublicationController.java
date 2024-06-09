package com.event.wear.platform.publication.interfaces.rest;

import com.event.wear.platform.publication.domain.model.aggregates.Publication;
import com.event.wear.platform.publication.domain.model.commands.DeletePublicationCommand;
import com.event.wear.platform.publication.domain.model.queries.*;
import com.event.wear.platform.publication.domain.services.PublicationCommandService;
import com.event.wear.platform.publication.domain.services.PublicationQueryService;
import com.event.wear.platform.publication.interfaces.rest.resources.AddCommentToPublicationResource;
import com.event.wear.platform.publication.interfaces.rest.resources.CommentResource;
import com.event.wear.platform.publication.interfaces.rest.resources.CreatePublicationResource;
import com.event.wear.platform.publication.interfaces.rest.resources.GarmentResource;
import com.event.wear.platform.publication.interfaces.rest.resources.PublicationResource;
import com.event.wear.platform.publication.interfaces.rest.resources.UpdatePublicationResource;
import com.event.wear.platform.publication.interfaces.rest.transform.AddCommentCommandFromResourceAssembler;
import com.event.wear.platform.publication.interfaces.rest.transform.CommentResourceFromEntityAssembler;
import com.event.wear.platform.publication.interfaces.rest.transform.CreatePublicationCommandFromResourceAssembler;
import com.event.wear.platform.publication.interfaces.rest.transform.GarmentResourceFromEntityAssembler;
import com.event.wear.platform.publication.interfaces.rest.transform.PublicationResourceFromEntityAssembler;
import com.event.wear.platform.publication.interfaces.rest.transform.UpdatePublicationCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/publications", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag (name = "Publication", description = "Publication Management Endpoint")
public class PublicationController {
    private final PublicationCommandService publicationCommandService;
    private final PublicationQueryService publicationQueryService;
    public PublicationController(PublicationCommandService publicationCommandService, PublicationQueryService publicationQueryService) {
        this.publicationCommandService = publicationCommandService;
        this.publicationQueryService = publicationQueryService;
    }

    @PostMapping("/create-publication")
    public ResponseEntity<PublicationResource> createPublication(@RequestBody CreatePublicationResource resource) {
        var createPublicationCommand = new CreatePublicationCommandFromResourceAssembler().toCommandFromResource(resource);
        var publication = publicationCommandService.handle(createPublicationCommand);
        if (publication == null) {
            return ResponseEntity.badRequest().build();
        }
        var publicationResource = new PublicationResourceFromEntityAssembler().toResourceFromEntity(publication);
        return new ResponseEntity<>(publicationResource, HttpStatus.CREATED);
    }

    @PutMapping("/{publicationId}/update-publication")
    public ResponseEntity<PublicationResource> updatePublication(@PathVariable Long publicationId, @RequestBody UpdatePublicationResource resource) {
        if (publicationId == null) {
            return ResponseEntity.badRequest().build();
        }
        var updatePublicationResource = new UpdatePublicationResource(publicationId, resource.cost(), resource.lessorId(), resource.title(), resource.description(), resource.size());
        var updatePublicationCommand = new UpdatePublicationCommandFromResourceAssembler().toCommandFromResource(updatePublicationResource);
        Optional<Publication> publicationOptional = publicationCommandService.handle(updatePublicationCommand);
        if (publicationOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var publicationResource = new PublicationResourceFromEntityAssembler().toResourceFromEntity(publicationOptional.get());
        return new ResponseEntity<>(publicationResource, HttpStatus.CREATED);
    }
    @DeleteMapping("/{publicationId}/delete-publication")
    public ResponseEntity<Void> deletePublication(@PathVariable Long publicationId) {
        if (publicationId == null) {
            return ResponseEntity.badRequest().build();
        }
        publicationCommandService.handle(new DeletePublicationCommand(publicationId));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{publicationId}/add-comment")
    public ResponseEntity<PublicationResource> addCommentToPublication(@PathVariable Long publicationId, @RequestBody AddCommentToPublicationResource resource) {
        if (publicationId == null) {
            return ResponseEntity.badRequest().build();
        }
        var addCommentToPublicationResource = new AddCommentToPublicationResource(publicationId, resource.content(), resource.rating());
        var addCommentToPublicationCommand = new AddCommentCommandFromResourceAssembler().toCommandFromResource(addCommentToPublicationResource);
        var publication = publicationCommandService.handle(addCommentToPublicationCommand);
        var publicationResource = new PublicationResourceFromEntityAssembler().toResourceFromEntity(publication);
        if (publication == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(publicationResource, HttpStatus.CREATED);
    }

    @GetMapping("/all-publications")
    public ResponseEntity<List<PublicationResource>> getAllPublications() {
        var getAllPublicationsQuery = new GetAllPublicationsQuery();
        var publications = publicationQueryService.handle(getAllPublicationsQuery);
        var publicationResources = publications.stream().map(PublicationResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return new ResponseEntity<>(publicationResources, HttpStatus.OK);
    }

    @GetMapping("/{publicationId}")
    public ResponseEntity<PublicationResource> getPublicationById(@PathVariable Long publicationId) {
        if (publicationId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getPublicationByIdQuery = new GetPublicationByIdQuery(publicationId);
        var publication = publicationQueryService.handle(getPublicationByIdQuery);
        if (publication.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var publicationResource = new PublicationResourceFromEntityAssembler().toResourceFromEntity(publication.get());
        return new ResponseEntity<>(publicationResource, HttpStatus.OK);
    }

    @GetMapping("/{lessorId}/publications")
    public ResponseEntity<List<PublicationResource>> getPublicationsByLessorId(@PathVariable Long lessorId) {
        if (lessorId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getPublicationsByLessorIdQuery = new GetPublicationByLessorIdQuery(lessorId);
        var publications = publicationQueryService.handle(getPublicationsByLessorIdQuery);
        var publicationResources = publications.stream().map(PublicationResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return new ResponseEntity<>(publicationResources, HttpStatus.OK);
    }

    @GetMapping("/all-comments")
    public ResponseEntity<List<CommentResource>> getAllComments() {
        var getAllCommentsQuery = new GetAllCommentsQuery();
        var comments = publicationQueryService.handle(getAllCommentsQuery);
        var commentResources = comments.stream().map(CommentResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return new ResponseEntity<>(commentResources, HttpStatus.OK);
    }

    @GetMapping("/{publicationId}/comments")
    public ResponseEntity<List<CommentResource>> getCommentsByPublicationId(@PathVariable Long publicationId) {
        if (publicationId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getCommentsByPublicationIdQuery = new GetCommentsByPublicationIdQuery(publicationId);
        var comments = publicationQueryService.handle(getCommentsByPublicationIdQuery);
        var commentResources = comments.stream().flatMap(List::stream).map(CommentResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return new ResponseEntity<>(commentResources, HttpStatus.OK);
    }
    @GetMapping("/{publicationId}/garment")
    public ResponseEntity<GarmentResource> getGarmentByPublicationId(@PathVariable Long publicationId) {
        if (publicationId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getGarmentByPublicationIdQuery = new GetGarmentByPublicationIdQuery(publicationId);
        var garment = publicationQueryService.handle(getGarmentByPublicationIdQuery);
        if (garment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var garmentResource = new GarmentResourceFromEntityAssembler().toResourceFromEntity(garment.get());
        return new ResponseEntity<>(garmentResource, HttpStatus.OK);
    }

}
