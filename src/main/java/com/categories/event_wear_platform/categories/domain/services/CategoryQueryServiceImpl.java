package com.categories.event_wear_platform.categories.domain.services;

import com.categories.event_wear_platform.categories.domain.model.aggregates.Category;
import com.categories.event_wear_platform.categories.infrastructure.persistence.jpa.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryQueryServiceImpl implements CategoryQueryService {
    private final CategoryRepository categoryRepository;

    public CategoryQueryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(String id) {
        return categoryRepository.findById(id);
    }

    public List<Category> findFavorites() {
        return categoryRepository.findByIsFavorite(true);
    }

    public void deleteById(String id) {
        categoryRepository.deleteById(id);
    }
}
