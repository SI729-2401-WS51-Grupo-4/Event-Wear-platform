package com.event.wear.platform.rent.domain.model.entities;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.commands.AddCartItemCommand;
import com.event.wear.platform.rent.domain.model.valueobjects.PublicationId;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import com.event.wear.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Entity
@Table(name = "cart_item")
public class CartItem extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    @Setter
    @ManyToOne
    @JoinColumn(name = "shoppingcart_id")
    private ShoppingCart shoppingCart;

    @Embedded
    private PublicationId publicationId;

    @Setter
    private Integer quantity;

    @Embedded
    private UserId userId;

    public CartItem() {
        this.publicationId = new PublicationId();
        this.quantity = 0;
        this.userId = new UserId();
    }


    public CartItem(AddCartItemCommand command) {
        this.userId = new UserId(command.userId());
        this.publicationId = new PublicationId(command.publicationId());
        this.quantity = command.quantity();
    }


}
