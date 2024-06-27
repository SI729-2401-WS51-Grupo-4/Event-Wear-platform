package com.event.wear.platform.rent.domain.model.aggregates;

import com.event.wear.platform.rent.domain.model.commands.CreateShoppingCartCommand;
import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import com.event.wear.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
public class ShoppingCart extends AuditableAbstractAggregateRoot<ShoppingCart> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UserId userId;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CartItem> items= new ArrayList<>();

    public ShoppingCart(CreateShoppingCartCommand command) {
        this.userId = new UserId(command.userId());
    }

    public ShoppingCart() {

    }

    public void removeItem(CartItem item) {
        items.remove(item);
        item.setShoppingCart(null);
    }

    public void updateItemQuantity(CartItem itemToUpdate, Integer integer) {
        if (integer < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        itemToUpdate.setQuantity(integer);
    }
}