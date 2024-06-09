package com.categories.event_wear_platform.categories.domain.model.valueobjects;

import com.categories.event_wear_platform.categories.domain.model.aggregates.Category;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "publications")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String size;
    private String description;
    private String material;
    private String brand;
    private int timesRented;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Getters, setters...

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
