package com.categories.event_wear_platform.categories.infrastructure.persistence.jpa.repositories;

import com.categories.event_wear_platform.categories.domain.model.aggregates.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findByIsFavorite(boolean isFavorite);

}
