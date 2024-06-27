package com.event.wear.platform.categories.domain.services;

import com.event.wear.platform.categories.domain.model.aggregates.Category;
import com.event.wear.platform.categories.domain.model.commands.*;
import com.event.wear.platform.categories.infrastructure.persistence.jpa.repositories.CategoryRepository;

import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired

    public CategoryCommandServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> handle( @Valid CreateCategoryCommand command) {
        Category category = new Category(command.getPrice_range(),  command.getCategory_type(), command.getCategory_name(), command.getImage2(), command.getDescription(), command.getRate(), command.getIsFavorite());

        categoryRepository.save(category);
        return Optional.of(category);
    }



    @Override
    public Optional<Category> handle(@Valid UpdateCategoryCommand command) {
        Optional<Category> categoryOpt = categoryRepository.findById(command.getId());
        if (categoryOpt.isPresent()) {
            Category category = categoryOpt.get();
            category.setPrice_range(command.getPrice_range());
            category.setCategory_type(command.getCategory_type());
            category.setCategory_name(command.getCategory_name());
            category.setImage2(command.getImage2());
            category.setDescription(command.getDescription());
            category.setRate(command.getRate());
            category.setIsFavorite(command.getIsFavorite());
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
            category.setIsFavorite(true);
            categoryRepository.save(category);
            return Optional.of(category);
        }
        return Optional.empty();
    }


}
