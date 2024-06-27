package com.event.wear.platform.categories.domain.model.commands;

public class UpdateCategoryCommand {

    private String id;
    private Long price_range;
    private String category_type;
    private String category_name;
    private String image2;
    private String description;
    private Float rate;
    private boolean isFavorite;


    public String getId(){return id;}
    public void setId(String id){this.id=id;}
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
