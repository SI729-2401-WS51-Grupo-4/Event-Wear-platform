package com.event.wear.platform.rent.interfaces.rest;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.commands.AddItemToCartCommand;
import com.event.wear.platform.rent.domain.model.commands.DeleteCartItemCommand;
import com.event.wear.platform.rent.domain.model.commands.UpdateCartItemCommand;
import com.event.wear.platform.rent.domain.model.queries.GetAllCartItemsByUserIdQuery;
import com.event.wear.platform.rent.domain.model.queries.GetShoppingCartIdByUserIdQuery;
import com.event.wear.platform.rent.domain.model.queries.GetUserShoppingCartQuery;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import com.event.wear.platform.rent.domain.services.RentCommandService;
import com.event.wear.platform.rent.domain.services.RentQueryService;
import com.event.wear.platform.rent.interfaces.rest.resources.AddItemToCartResource;
import com.event.wear.platform.rent.interfaces.rest.resources.DeleteCartItemResource;
import com.event.wear.platform.rent.interfaces.rest.resources.UpdateCartItemResource;
import com.event.wear.platform.rent.interfaces.rest.transform.AddItemToCartCommandFromResourceAssembler;
import com.event.wear.platform.rent.interfaces.rest.transform.DeleteCartItemCommandFromResourceAssembler;
import com.event.wear.platform.rent.interfaces.rest.transform.UpdateCartItemCommandFromResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private final RentCommandService commandService;
    private final RentQueryService queryService;
    private final AddItemToCartCommandFromResourceAssembler addItemAssembler;
    private final DeleteCartItemCommandFromResourceAssembler deleteItemAssembler;
    private final UpdateCartItemCommandFromResourceAssembler updateItemAssembler;

    public ShoppingCartController(RentCommandService commandService, RentQueryService queryService, AddItemToCartCommandFromResourceAssembler addItemAssembler, DeleteCartItemCommandFromResourceAssembler deleteItemAssembler, UpdateCartItemCommandFromResourceAssembler updateItemAssembler) {
        this.commandService = commandService;
        this.queryService = queryService;
        this.addItemAssembler = addItemAssembler;
        this.deleteItemAssembler = deleteItemAssembler;
        this.updateItemAssembler = updateItemAssembler;
    }


    @PostMapping("/add")
    public ResponseEntity<Void> addItemToCart(@RequestBody AddItemToCartResource resource) {
        Long userId = resource.userId();
        UserId userIdInstance = new UserId(userId);
        var userShoppingCart = queryService.handle(new GetUserShoppingCartQuery(userIdInstance.value()));

        ShoppingCart shoppingCart;
        if (userShoppingCart.isEmpty()) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setUserId(userId);
        } else {
            shoppingCart = userShoppingCart.get();
        }

        var existingItem = shoppingCart.getItems().stream()
                .filter(item -> item.getPublicationId().equals(resource.getPublicationId()))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity((int) (existingItem.get().getQuantity() + resource.quantity()));
        } else {
            AddItemToCartCommand command = addItemAssembler.toCommandFromResource(resource);
            commandService.handle(command);
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{userId}/{cartItemId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long userId, @PathVariable Long cartItemId) {
        DeleteCartItemResource resource = new DeleteCartItemResource(userId, cartItemId);
        DeleteCartItemCommand command = deleteItemAssembler.toCommandFromResource(resource);
        commandService.handle(command);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateCartItem(@RequestBody UpdateCartItemResource resource) {
        UpdateCartItemCommand command = updateItemAssembler.toCommandFromResource(resource);
        commandService.handle(command);
        return ResponseEntity.ok().build();
    }

      @GetMapping("/items/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getAllCartItemsByUserId(@PathVariable Long userId) {
    List<Map<String, Object>> items = queryService.handle(new GetAllCartItemsByUserIdQuery(userId));
    return ResponseEntity.ok(items);
    }

    @GetMapping("/id/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getShoppingCartIdByUserId(@PathVariable Long userId) {
    List<Map<String, Object>> shoppingCartId = queryService.handle(new GetShoppingCartIdByUserIdQuery(userId));
    return ResponseEntity.ok(shoppingCartId);
    }


}