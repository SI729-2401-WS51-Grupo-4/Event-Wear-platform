package com.event.wear.platform.publication.domain.model.commands;

import com.event.wear.platform.publication.domain.model.entities.Garment;
import com.event.wear.platform.publication.domain.model.valueobjects.LessorId;

public record UpdatePublicationCommand(Long publicationId, Integer cost, LessorId lessorId, Garment garment) {
}
