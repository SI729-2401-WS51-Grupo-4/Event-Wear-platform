package com.event.wear.platform.categories.domain.model.commands;

public class GetPublicationsToCategoryCommand {
    private final String categoryId;

    public GetPublicationsToCategoryCommand(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }
}