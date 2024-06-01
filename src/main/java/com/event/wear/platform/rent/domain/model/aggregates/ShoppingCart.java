package com.event.wear.platform.rent.domain.model.aggregates;

import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class ShoppingCart extends AbstractAggregateRoot<ShoppingCart> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UserId userId;

    @Setter
    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> items;

    public ShoppingCart() {
        // Constructor sin argumentos
    }

    public ShoppingCart(UserId userId) {
        this.userId = userId;
        this.items = new ArrayList<>();
    }

    public void addItem(CartItem item) {
        this.items.add(item);
        item.setShoppingCart(this);
    }

    public Long value() {
        return id;
    }
}