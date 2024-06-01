package com.event.wear.platform.rent.domain.model.aggregates;

import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
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
    private UserId userId;

    @Getter
    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> items = new ArrayList<>(); // Initialize the list

    public ShoppingCart() {
    }

    public void addItem(CartItem item) {
        items.add(item);
        item.setShoppingCart(this);
    }

    public UserId value() {
        return userId;
    }

}