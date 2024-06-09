package com.categories.event_wear_platform.categories.domain.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String aLong) {
        super("Category with id " + aLong + " not found");
    }
}
