package com.event.wear.platform.rent.interfaces.rest;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.commands.AddItemToCartCommand;
import com.event.wear.platform.rent.domain.model.commands.DeleteCartItemCommand;
import com.event.wear.platform.rent.domain.model.queries.GetUserShoppingCartQuery;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import com.event.wear.platform.rent.domain.services.RentCommandService;
import com.event.wear.platform.rent.domain.services.RentQueryService;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import com.event.wear.platform.rent.interfaces.rest.resources.AddItemToCartResource;
import com.event.wear.platform.rent.interfaces.rest.resources.DeleteCartItemResource;
import com.event.wear.platform.rent.interfaces.rest.transform.AddItemToCartCommandFromResourceAssembler;
import com.event.wear.platform.rent.interfaces.rest.transform.DeleteCartItemCommandFromResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private final RentCommandService commandService;
    private final RentQueryService queryService;
    private final AddItemToCartCommandFromResourceAssembler addItemAssembler;
    private final DeleteCartItemCommandFromResourceAssembler deleteItemAssembler;

    public ShoppingCartController(RentCommandService commandService, RentQueryService queryService, AddItemToCartCommandFromResourceAssembler addItemAssembler, DeleteCartItemCommandFromResourceAssembler deleteItemAssembler, ShoppingCartRepository shoppingCartRepository) {
        this.commandService = commandService;
        this.queryService = queryService;
        this.addItemAssembler = addItemAssembler;
        this.deleteItemAssembler = deleteItemAssembler;
    }

    /*http://localhost:8090/cart/add*/
    @PostMapping("/add")
    public ResponseEntity<Void> addItemToCart(@RequestBody AddItemToCartResource resource) {
        UserId userIdObj = resource.userId();
        var userShoppingCart = queryService.handle(new GetUserShoppingCartQuery(userIdObj.value()));

        ShoppingCart shoppingCart;
        if (userShoppingCart.isEmpty()) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setUserId(userIdObj);
        } else {
            shoppingCart = userShoppingCart.get();
        }

        // Verificar si el artículo ya existe en el carrito
        var existingItem = shoppingCart.getItems().stream()
                .filter(item -> item.getPublicationId().equals(resource.publicationId()))
                .findFirst();

        if (existingItem.isPresent()) {
            // Si el artículo ya existe, actualizar la cantidad
            existingItem.get().setQuantity(existingItem.get().getQuantity() + resource.quantity());
        } else {
            // Si el artículo no existe, crear uno nuevo
            AddItemToCartCommand command = addItemAssembler.toCommandFromResource(userIdObj, shoppingCart, resource);
            commandService.handle(command);
        }

        return ResponseEntity.ok().build();
    }

    /*http://localhost:8090/cart/delete/{userId}/{cartItemId}*/
    @DeleteMapping("/delete/{userId}/{cartItemId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long userId, @PathVariable Long cartItemId) {
        DeleteCartItemResource resource = new DeleteCartItemResource(new UserId(userId), cartItemId);
        DeleteCartItemCommand command = deleteItemAssembler.toCommandFromResource(resource);
        commandService.handle(command);
        return ResponseEntity.ok().build();
    }


}