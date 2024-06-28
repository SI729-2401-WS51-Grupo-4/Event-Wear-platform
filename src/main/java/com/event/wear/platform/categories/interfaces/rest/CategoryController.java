package com.event.wear.platform.categories.interfaces.rest;

import com.event.wear.platform.categories.domain.model.aggregates.Category;
import com.event.wear.platform.categories.domain.model.commands.*;
import com.event.wear.platform.categories.domain.services.CategoryCommandService;
import com.event.wear.platform.categories.domain.services.CategoryQueryService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.Optional;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    private final CategoryCommandService categoryCommandService;
    private final CategoryQueryService categoryQueryService;

    public CategoryController(CategoryCommandService categoryCommandService, CategoryQueryService categoryQueryService) {
        this.categoryCommandService = categoryCommandService;
        this.categoryQueryService = categoryQueryService;
    }
    @Operation(summary = "Create a new category")
    @CrossOrigin(origins = "http://localhost:4200/category")
    @PostMapping
    public ResponseEntity<?> createCategory(@Valid @RequestBody CreateCategoryCommand command) {
        try {
            Optional<Category> category = categoryCommandService.handle(command);
            return category.map(value -> new ResponseEntity<>(value, HttpStatus.CREATED))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @Operation(summary = "Get all categories")
    @CrossOrigin(origins = "http://localhost:4200/category")
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryQueryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Operation(summary = "Get a category by ID")
    @CrossOrigin(origins = "http://localhost:4200/category")
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable String id) {
        Optional<Category> category = categoryQueryService.findById(id);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Delete a category by ID")
    @CrossOrigin(origins = "http://localhost:4200/category")
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
    @CrossOrigin(origins = "http://localhost:4200/category")
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable String id, @RequestBody UpdateCategoryCommand command) {
        command.setId(id);
        Optional<Category> category = categoryCommandService.handle(command);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(summary = "Add a category to favorites")
    @CrossOrigin(origins = "http://localhost:4200/category")
    @PostMapping("/{id}/favorite")
    public ResponseEntity<Category> addCategoryToFavorites(@PathVariable String id) {
        AddCategoryToFavoritesCommand command = new AddCategoryToFavoritesCommand(id);
        command.setCategoryId(id);
        Optional<Category> category = categoryCommandService.handle(command);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(summary = "Get favorite categories")
    @CrossOrigin(origins = "http://localhost:4200/category")
    @GetMapping("/favorites")
    public ResponseEntity<List<Category>> getFavoriteCategories() {
        List<Category> categories = categoryQueryService.findFavorites();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


}
