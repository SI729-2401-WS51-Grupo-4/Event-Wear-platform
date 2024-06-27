package com.event.wear.platform.categories.domain.model.commands;

import java.util.List;

public class SetPublicationsToCategoryCommand {
    private final String categoryId;

    public SetPublicationsToCategoryCommand(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }
}
