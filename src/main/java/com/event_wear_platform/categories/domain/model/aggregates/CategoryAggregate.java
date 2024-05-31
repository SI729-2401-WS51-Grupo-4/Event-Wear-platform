package com.event_wear_platform.categories.domain.model.aggregates;

import com.event_wear_platform.categories.domain.model.entities.Category;
import com.event_wear_platform.categories.domain.model.valueobjects.CategoryId;

import java.util.List;

public class CategoryAggregate {
    private CategoryId categoryId;
    private Category category;
    private List<Category> subCategories;

    // Constructor, getters y setters
}
