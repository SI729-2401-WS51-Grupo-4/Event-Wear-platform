package com.categories.event_wear_platform.categories.domain.model.commands;

public class UpdateCategoryCommand {
    private String id;
    private String name;
    private String description;
    private String status;
    private boolean isFavorite;
    // Getters y setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description=description;}
    public String getStatus() { return status; } // Getter para status
    public void setStatus(String status) { this.status = status; }
    public boolean isFavorite() {
        return isFavorite;
    }
    public void setFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
