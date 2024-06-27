package com.event.wear.platform.categories.domain.services;

import com.event.wear.platform.categories.domain.model.aggregates.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryQueryService {
    List<Category> findAll();
    Optional<Category> findById(String id);

    List<Category> findFavorites();
        // Lógica para obtener las categorías favoritas

    void deleteById(String id);
}