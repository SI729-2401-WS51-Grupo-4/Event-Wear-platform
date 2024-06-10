package com.event.wear.platform.rent.domain.model.entities;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.valueobjects.PublicationId;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
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
    @Embedded
    private UserId userId;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCartid;

    @Setter
    @Getter
    @Embedded
    private PublicationId publicationId;

    @Setter
    @Getter
    private int quantity;

    public CartItem() {

    }

    public CartItem(UserId userId, PublicationId publicationId, int quantity) {
        this.userId = userId;
        this.publicationId = publicationId;
        this.quantity = quantity;
    }

    public Object getId() {
        return id;
    }

    public Object getShoppingcart_id() {
        return shoppingCartid.getId();
    }
}