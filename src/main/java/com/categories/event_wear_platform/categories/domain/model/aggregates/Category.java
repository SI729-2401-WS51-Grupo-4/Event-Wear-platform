package com.categories.event_wear_platform.categories.domain.model.aggregates;

import com.categories.event_wear_platform.categories.domain.model.valueobjects.Publication;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    // Getters and setters
    @Setter
    @Getter
    @Id
    private String id;
    @Setter
    @Getter
    @Column(nullable = false)
    private String name;
    @Setter
    @Getter
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private boolean isFavorite;
    protected Category() { }
    @Setter
    @Getter
    @Column(nullable = false)
    private String status;

    public Category(String id, String name, String description, boolean isFavorite, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isFavorite = isFavorite;
        this.status = status;
    }

    public boolean isFavorite() {
        return isFavorite;
    }
    public void setFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Publication> publications = new ArrayList<>();

    // Other fields, getters, setters...

    public void addPublication(Publication publication) {
        publications.add(publication);
        publication.setCategory(this);
    }

    public void removePublication(Publication publication) {
        publications.remove(publication);
        publication.setCategory(null);
    }

    public void setPublications(List<Publication> publications) {
        this.publications.clear();
        if (publications != null) {
            for (Publication publication : publications) {
                addPublication(publication);
            }
        }
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public List<Publication> getPublications() {
        return publications;
    }

}
