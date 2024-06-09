package com.categories.event_wear_platform.categories.domain.services;

import com.categories.event_wear_platform.categories.domain.model.aggregates.Category;
import com.categories.event_wear_platform.categories.domain.model.commands.*;
import com.categories.event_wear_platform.categories.domain.model.valueobjects.Publication;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;


public interface CategoryCommandService {
    Optional<Category> handle(CreateCategoryCommand command);

    Optional<Category> handle(UpdateCategoryCommand command);

    Optional<Category> handle(AddCategoryToFavoritesCommand command);

    Category handleAddPublicationToCategory(AddPublicationToCategoryCommand command);

    List<Publication> handleGetPublicationsToCategory(GetPublicationsToCategoryCommand command);

    Category handleSetPublicationsToCategory(SetPublicationsToCategoryCommand command);

    Category handleRemovePublicationFromCategory(RemovePublicationFromCategoryCommand command) throws BadRequestException;
}
