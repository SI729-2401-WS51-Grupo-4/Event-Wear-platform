package com.categories.event_wear_platform.categories.domain.model.commands;

import com.categories.event_wear_platform.categories.domain.model.valueobjects.Publication;

import java.util.List;

public class SetPublicationsToCategoryCommand {
    private final String categoryId;
    private final List<Publication> publications;

    public SetPublicationsToCategoryCommand(String categoryId, List<Publication> publications) {
        this.categoryId = categoryId;
        this.publications = publications;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public List<Publication> getPublications() {
        return publications;
    }
}
