package com.event.wear.platform.Rent.domain.model.entities;

import com.event.wear.platform.Rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.Rent.domain.model.valueobjects.PublicationId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "rental_id")
    private ShoppingCart rental;

    @Setter
    @Getter
    @Embedded
    private PublicationId publicationId;

    @Setter
    @Getter
    private int quantity;

    public CartItem() {
        // Constructor without arguments
    }

    public CartItem(ShoppingCart shoppingCart, PublicationId publicationId, int quantity) {
        this.shoppingCart = shoppingCart;
        this.publicationId = publicationId;
        this.quantity = quantity;
    }

    public Object getId() {
        return id;
    }

    // Getters y setters

}
