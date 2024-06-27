package com.event.wear.platform.categories.domain.model.commands;

public class RemovePublicationFromCategoryCommand {
    private final String categoryId;
    private final Long publicationId;

    public RemovePublicationFromCategoryCommand(String categoryId, Long publicationId) {
        this.categoryId = categoryId;
        this.publicationId = publicationId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public Long getPublicationId() {
        return publicationId;
    }
}
