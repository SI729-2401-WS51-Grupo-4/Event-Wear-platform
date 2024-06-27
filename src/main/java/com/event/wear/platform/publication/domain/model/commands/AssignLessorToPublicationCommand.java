package com.event.wear.platform.publication.domain.model.commands;

import com.event.wear.platform.publication.domain.model.valueobjects.LessorId;

public record AssignLessorToPublicationCommand(Long publicationId, LessorId lessorId) {
}