package com.categories.event_wear_platform.categories.domain.services;

import com.categories.event_wear_platform.categories.domain.model.aggregates.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryQueryService {
    List<Category> findAll();
    Optional<Category> findById(String id);

    List<Category> findFavorites();
        // Lógica para obtener las categorías favoritas

    void deleteById(String id);
}