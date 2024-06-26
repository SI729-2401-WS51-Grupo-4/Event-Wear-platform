package com.categories.event_wear_platform.categories.domain.services;

import com.categories.event_wear_platform.categories.domain.model.aggregates.Category;
import com.categories.event_wear_platform.categories.domain.model.commands.*;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;


public interface CategoryCommandService {
    Optional<Category> handle(CreateCategoryCommand command);

    Optional<Category> handle(UpdateCategoryCommand command);

    Optional<Category> handle(AddCategoryToFavoritesCommand command);

}
