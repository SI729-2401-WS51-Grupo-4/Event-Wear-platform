package com.categories.event_wear_platform.categories.domain.model.aggregates;

import com.categories.event_wear_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"image", "image2"}),
                @UniqueConstraint(columnNames = {"description", "category_type"})
        })
public class Category extends AuditableAbstractAggregateRoot<Category> {

    @Setter
    @Getter
    @NotNull
    @PositiveOrZero(message = "Price range must be zero or positive.")
    @Column(nullable = false)
    private Long price_range;

    @Setter
    @Getter
    @NotNull
    @Column(nullable = false)
    private String category_type;

    @Setter
    @Getter
    @NotNull
    @Column(nullable = false)
    private String category_name;

    @Setter
    @Getter
    @NotNull
    @Column(nullable = false, unique = true)
    private String image2;

    @Setter
    @Getter
    @NotNull
    @Column(nullable = false, unique = true)
    private String description;

    @Setter
    @Getter
    @PositiveOrZero(message = "Rate must be zero or positive.")
    @NotNull
    @Column(nullable = false)
    private Float rate;

    @Setter
    @Getter
    @NotNull
    @Column(nullable = false)
    private boolean isFavorite;

    protected Category() { }

    public Category(Long price_range, String category_type,String category_name, String image2, String description, Float rate, boolean isFavorite) {
        this.price_range = price_range;
        this.category_name = category_name;
        this.category_type = category_type;
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
    public void setCategory_name(String category_name){this.category_name = category_name;}

    public String getImage2() {return image2;}
    public void setImage2(String image2) {this.image2 = image2;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Float getRate() {return rate;}
    public void setRate(Float rate) {this.rate = rate;}

    public boolean getIsFavorite() {return isFavorite;}
    public void setIsFavorite(boolean isFavorite) {this.isFavorite = isFavorite;}
}
