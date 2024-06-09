package com.categories.event_wear_platform.categories.domain.model.commands;

public class AddCategoryToFavoritesCommand {
    private String categoryId;

    public AddCategoryToFavoritesCommand(String categoryId) {
        this.categoryId = categoryId;
    }

    // Getters y setters

    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String id) { this.categoryId = categoryId; }


}