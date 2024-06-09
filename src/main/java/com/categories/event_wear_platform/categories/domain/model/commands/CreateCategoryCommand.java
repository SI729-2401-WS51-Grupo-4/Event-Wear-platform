package com.categories.event_wear_platform.categories.domain.model.commands;

public class CreateCategoryCommand {
    private  String id; //QUITAR EL final
    private String name;
    private String description;
    private String status;
    private boolean isFavorite;
    public CreateCategoryCommand() {}

    // Constructors, getters, and setters
    public CreateCategoryCommand(String id, String name, String description, boolean isFavorite, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isFavorite = isFavorite;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() {return description;}
    public void setDescription(String description) { this.description = description; }
    public boolean isFavorite() {return isFavorite;}
    public void setFavorite(boolean isFavorite) { this.isFavorite = isFavorite; }
    public String getStatus() { return status; } // Getter para status
    public void setStatus(String status) { this.status = status; }
}
