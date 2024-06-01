package com.event.wear.platform.rent.interfaces.rest;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.commands.AddItemToCartCommand;
import com.event.wear.platform.rent.domain.model.queries.GetUserShoppingCartQuery;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import com.event.wear.platform.rent.domain.services.RentCommandService;
import com.event.wear.platform.rent.domain.services.RentQueryService;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import com.event.wear.platform.rent.interfaces.rest.resources.AddItemToCartResource;
import com.event.wear.platform.rent.interfaces.rest.transform.AddItemToCartCommandFromResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private final RentCommandService commandService;
    private final RentQueryService queryService;
    private final AddItemToCartCommandFromResourceAssembler assembler;

    public ShoppingCartController(RentCommandService commandService, RentQueryService queryService, AddItemToCartCommandFromResourceAssembler assembler,ShoppingCartRepository shoppingCartRepository) {
        this.commandService = commandService;
        this.queryService = queryService;
        this.assembler = assembler;
    }

@PostMapping("/add/{userId}")
public ResponseEntity<Void> addItemToCart(@RequestBody AddItemToCartResource resource, @PathVariable Long userId) {
    UserId userIdObj = new UserId(userId);
    var userShoppingCart = queryService.handle(new GetUserShoppingCartQuery(userId));

    ShoppingCart shoppingCart;
    if (userShoppingCart.isEmpty()) {
        shoppingCart = new ShoppingCart();
        shoppingCart.setUserId(userIdObj);
    } else {
        shoppingCart = userShoppingCart.get();
    }

    // Check if the item already exists in the cart
    var existingItem = shoppingCart.getItems().stream()
        .filter(item -> item.getPublicationId().equals(resource.publicationId()))
        .findFirst();

    if (existingItem.isPresent()) {
        // If the item already exists, update the quantity
        existingItem.get().setQuantity(existingItem.get().getQuantity() + resource.quantity());
    } else {
        // If the item does not exist, create a new one
        AddItemToCartCommand command = assembler.toCommand(userIdObj, shoppingCart, resource);
        commandService.handle(command);
    }

    return ResponseEntity.ok().build();
}

}