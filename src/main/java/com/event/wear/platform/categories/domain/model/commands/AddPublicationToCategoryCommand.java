package com.event.wear.platform.categories.domain.model.commands;

public class AddPublicationToCategoryCommand {
    private final String categoryId;

    public AddPublicationToCategoryCommand(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }
}
