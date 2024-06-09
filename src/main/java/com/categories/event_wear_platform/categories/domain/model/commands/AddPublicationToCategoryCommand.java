package com.categories.event_wear_platform.categories.domain.model.commands;

import com.categories.event_wear_platform.categories.domain.model.valueobjects.Publication;

public class AddPublicationToCategoryCommand {
    private final String categoryId;
    private final Publication publication;

    public AddPublicationToCategoryCommand(String categoryId, Publication publication) {
        this.categoryId = categoryId;
        this.publication = publication;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public Publication getPublication() {
        return publication;
    }
}
