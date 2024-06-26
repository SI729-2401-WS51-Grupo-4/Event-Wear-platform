package com.categories.event_wear_platform.categories.domain.model.commands;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class CreateCategoryCommand {

    @NotNull
    @PositiveOrZero(message = "Price range must be zero or positive.")
    @NotNull
    private Long price_range;

    @NotNull
    private String category_type;

    @NotNull
    private String category_name;

    @NotNull
    private String image2;

    @NotNull
    private String description;

    @NotNull
    @PositiveOrZero(message = "Rate must be zero or positive.")
    private Float rate;

    @NotNull
    private boolean isFavorite;


    public CreateCategoryCommand() {}

    // Constructors, getters, and setters
    public CreateCategoryCommand(Long price_range, String category_type, String category_name, String image2, String description, Float rate, boolean isFavorite) {
        this.price_range = price_range;
        this.category_type = category_type;
        this.category_name = category_name;
        this.image2 = image2;
        this.description = description;
        this.rate = rate;
        this.isFavorite = isFavorite;
    }

    public Long getPrice_range() {return price_range;}
    public void setPrice_range(Long price_range) {this.price_range = price_range;}

    public String getCategory_type() {return category_type;}
    public void setCategory_type(String category_type) {this.category_type = category_type;}

    public String getCategory_name() {return category_name;}
    public void setCategory_name(String category_name) {this.category_name = category_name;}

    public String getImage2() {return image2;}
    public void setImage2(String image2) {this.image2 = image2;}

    public String getDescription() {return description;}
    public void setDescription(String description) { this.description = description; }

    public Float getRate() {return rate;}
    public void setRate(Float rate) {this.rate = rate;}

    public boolean getIsFavorite() {return isFavorite;}
    public void setIsFavorite(boolean isFavorite) {this.isFavorite = isFavorite;}
}
