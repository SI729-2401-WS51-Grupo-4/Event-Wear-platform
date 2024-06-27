package com.event.wear.platform.categories.infrastructure.persistence.jpa.repositories;

import com.event.wear.platform.categories.domain.model.aggregates.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findByIsFavorite(boolean isFavorite);

}
