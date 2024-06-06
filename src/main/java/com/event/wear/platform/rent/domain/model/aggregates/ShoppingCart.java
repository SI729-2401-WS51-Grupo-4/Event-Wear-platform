package com.event.wear.platform.rent.domain.model.aggregates;

import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity

public class ShoppingCart extends AbstractAggregateRoot<ShoppingCart> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoppingcart_id;

    private Long userId;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CartItem> items= new ArrayList<>(); // Initialize the list

    public ShoppingCart() {
    }

    public void addItem(CartItem item) {
        items.add(item);
        item.setShoppingCart(this);
    }

    public void removeItem(CartItem item) {
        items.remove(item);
        item.setShoppingCart(null);
    }

    public void updateItemQuantity(CartItem item, int newQuantity) {
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        item.setQuantity(newQuantity);
    }


}