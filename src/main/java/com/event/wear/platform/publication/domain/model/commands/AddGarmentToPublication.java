package com.event.wear.platform.publication.domain.model.commands;

import com.event.wear.platform.publication.domain.model.entities.Garment;

public record AddGarmentToPublication (Long publicationId, Garment garment) {
}
