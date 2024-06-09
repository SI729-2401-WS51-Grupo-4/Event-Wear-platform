package com.categories.event_wear_platform.categories.domain.services;

import com.categories.event_wear_platform.categories.domain.exceptions.CategoryNotFoundException;
import com.categories.event_wear_platform.categories.domain.model.aggregates.Category;
import com.categories.event_wear_platform.categories.domain.model.commands.*;
import com.categories.event_wear_platform.categories.domain.model.valueobjects.Publication;
import com.categories.event_wear_platform.categories.infrastructure.persistence.jpa.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

import com.categories.event_wear_platform.categories.infrastructure.persistence.jpa.repositories.PublicationRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final PublicationRepository publicationRepository;

    public CategoryCommandServiceImpl(CategoryRepository categoryRepository, PublicationRepository publicationRepository) {
        this.categoryRepository = categoryRepository;
        this.publicationRepository = publicationRepository;
    }

    @Override
    public Optional<Category> handle(CreateCategoryCommand command) {
        Category category = new Category(command.getId(), command.getName(), command.getDescription(), command.isFavorite(), command.getStatus());
        categoryRepository.save(category);
        return Optional.of(category);
    }

    @Override
    public Optional<Category> handle(UpdateCategoryCommand command) {
        Optional<Category> categoryOpt = categoryRepository.findById(command.getId());
        if (categoryOpt.isPresent()) {
            Category category = categoryOpt.get();
            category.setName(command.getName());
            category.setStatus(command.getStatus());
            category.setFavorite(command.isFavorite());
            category.setDescription(command.getDescription());
            categoryRepository.save(category);
            return Optional.of(category);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Category> handle(AddCategoryToFavoritesCommand command) {
        Optional<Category> categoryOpt = categoryRepository.findById(command.getCategoryId());
        if (categoryOpt.isPresent()) {
            Category category = categoryOpt.get();
            category.setFavorite(true);
            categoryRepository.save(category);
            return Optional.of(category);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Category handleAddPublicationToCategory(AddPublicationToCategoryCommand command) {
        Category category = categoryRepository.findById(command.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id " + command.getCategoryId()));

        Publication publication = command.getPublication();
        publication.setCategory(category);
        category.addPublication(publication);

        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category handleRemovePublicationFromCategory(RemovePublicationFromCategoryCommand command) throws BadRequestException {
        Category category = categoryRepository.findById(command.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id " + command.getCategoryId()));

        Publication publication = publicationRepository.findById(command.getPublicationId())
                .orElseThrow(() -> new CategoryNotFoundException("Publication not found with id " + command.getPublicationId()));

        if (publication.getCategory() != category) {
            throw new BadRequestException("Publication with id " + command.getPublicationId() + " does not belong to category with id " + command.getCategoryId());
        }

        publication.setCategory(null);
        category.removePublication(publication);

        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category handleSetPublicationsToCategory(SetPublicationsToCategoryCommand command) {
        Category category = categoryRepository.findById(command.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id " + command.getCategoryId()));

        category.setPublications(command.getPublications());

        for (Publication publication : command.getPublications()) {
            publication.setCategory(category);
        }

        return categoryRepository.save(category);
    }

    @Override
    public List<Publication> handleGetPublicationsToCategory(GetPublicationsToCategoryCommand command) {
        Category category = categoryRepository.findById(command.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id " + command.getCategoryId()));

        return category.getPublications();
    }
}
