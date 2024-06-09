package com.categories.event_wear_platform.categories.interfaces.rest;

import com.categories.event_wear_platform.categories.domain.model.aggregates.Category;
import com.categories.event_wear_platform.categories.domain.model.commands.*;
import com.categories.event_wear_platform.categories.domain.model.valueobjects.Publication;
import com.categories.event_wear_platform.categories.domain.services.CategoryCommandService;
import com.categories.event_wear_platform.categories.domain.services.CategoryQueryService;
import io.swagger.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryCommandService categoryCommandService;
    private final CategoryQueryService categoryQueryService;

    public CategoryController(CategoryCommandService categoryCommandService, CategoryQueryService categoryQueryService) {
        this.categoryCommandService = categoryCommandService;
        this.categoryQueryService = categoryQueryService;
    }

    @Operation(summary = "Create a new category")
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryCommand command) {
        Optional<Category> category = categoryCommandService.handle(command);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @Operation(summary = "Get all categories")
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryQueryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Operation(summary = "Get a category by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable String id) {
        Optional<Category> category = categoryQueryService.findById(id);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Delete a category by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable String id) {
        Optional<Category> category = categoryQueryService.findById(id);
        if (category.isPresent()) {
            categoryQueryService.deleteById(id); // Ensure you have a delete method in your service
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Update a category")
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable String id, @RequestBody UpdateCategoryCommand command) {
        command.setId(id);
        Optional<Category> category = categoryCommandService.handle(command);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Add a category to favorites")
    @PostMapping("/{id}/favorite")
    public ResponseEntity<Category> addCategoryToFavorites(@PathVariable String id) {
        AddCategoryToFavoritesCommand command = new AddCategoryToFavoritesCommand(id);
        command.setCategoryId(id);
        Optional<Category> category = categoryCommandService.handle(command);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Get favorite categories")
    @GetMapping("/favorites")
    public ResponseEntity<List<Category>> getFavoriteCategories() {
        List<Category> categories = categoryQueryService.findFavorites();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Operation(summary = "Falta Impl")
    @PostMapping("/{categoryId}/publications")
    public ResponseEntity<Category> addPublicationToCategory(@PathVariable String categoryId, @RequestBody Publication publication) {
        AddPublicationToCategoryCommand command = new AddPublicationToCategoryCommand(categoryId, publication);
        Category category = categoryCommandService.handleAddPublicationToCategory(command);
        return ResponseEntity.ok(category);
    }

    @Operation(summary = "Falta Impl")
    @DeleteMapping("/{categoryId}/publications/{publicationId}")
    public ResponseEntity<Category> removePublicationFromCategory(@PathVariable String categoryId, @PathVariable Long publicationId) throws BadRequestException {
        RemovePublicationFromCategoryCommand command = new RemovePublicationFromCategoryCommand(categoryId, publicationId);
        Category category = categoryCommandService.handleRemovePublicationFromCategory(command);
        return ResponseEntity.ok(category);
    }

    @Operation(summary = "Falta Impl")
    @PutMapping("/{categoryId}/publications")
    public ResponseEntity<Category> setPublicationsToCategory(@PathVariable String categoryId, @RequestBody List<Publication> publications) {
        SetPublicationsToCategoryCommand command = new SetPublicationsToCategoryCommand(categoryId, publications);
        Category category = categoryCommandService.handleSetPublicationsToCategory(command);
        return ResponseEntity.ok(category);
    }

    @Operation(summary = "Falta Impl")
    @GetMapping("/{categoryId}/publications")
    public ResponseEntity<List<Publication>> getPublicationsToCategory(@PathVariable String categoryId) {
        GetPublicationsToCategoryCommand command = new GetPublicationsToCategoryCommand(categoryId);
        List<Publication> publications = categoryCommandService.handleGetPublicationsToCategory(command);
        return ResponseEntity.ok(publications);
    }

}