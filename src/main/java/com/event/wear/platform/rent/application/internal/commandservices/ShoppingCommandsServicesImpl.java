package com.event.wear.platform.rent.application.internal.commandservices;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.commands.AddCartItemCommand;
import com.event.wear.platform.rent.domain.model.commands.CreateShoppingCartCommand;
import com.event.wear.platform.rent.domain.model.commands.DeleteCartItemCommand;
import com.event.wear.platform.rent.domain.model.commands.UpdateCartItemCommand;
import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import com.event.wear.platform.rent.domain.services.ShoppingCartCommandService;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.CartItemRepository;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCommandsServicesImpl implements ShoppingCartCommandService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;
    public ShoppingCommandsServicesImpl(ShoppingCartRepository shoppingCartRepository, CartItemRepository cartItemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public ShoppingCart handle(CreateShoppingCartCommand command) {
        var shoppingcart = new ShoppingCart(command);
        try {
            shoppingCartRepository.save(shoppingcart);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error creating shopping cart");
        }
        return shoppingcart;
    }

   @Override
   public void handle(DeleteCartItemCommand command) {
       Long userId = command.userId();
       ShoppingCart shoppingCart = shoppingCartRepository.findById(userId)
               .orElseThrow(() -> new IllegalArgumentException("ShoppingCart not found"));
       CartItem itemToRemove = shoppingCart.getItems().stream()
               .filter(item -> item.getId().equals(command.cartItemId()))
               .findFirst()
               .orElseThrow(() -> new IllegalArgumentException("CartItem not found"));
       shoppingCart.removeItem(itemToRemove);
       shoppingCartRepository.save(shoppingCart);
   }

    @Override
    public CartItem handle(AddCartItemCommand command) {
            UserId userId = new UserId(command.userId());

            Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findByUserId(userId);

            ShoppingCart shoppingCart;

            if (!shoppingCartOptional.isPresent()) {
                CreateShoppingCartCommand createShoppingCartCommand = new CreateShoppingCartCommand(command.userId());
                shoppingCart = this.handle(createShoppingCartCommand);
            } else {

                shoppingCart = shoppingCartOptional.get();
            }


            CartItem cartItem = new CartItem(command);
            cartItem.setShoppingCart(shoppingCart);

            try {
                cartItemRepository.save(cartItem);
            } catch (Exception e) {
                throw new IllegalArgumentException("Error adding cart item");
            }

            return cartItem;
    }

    @Override
    public void handle(UpdateCartItemCommand command) {
        Long userId = command.userId();
        ShoppingCart shoppingCart = shoppingCartRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("ShoppingCart not found"));
        CartItem itemToUpdate = shoppingCart.getItems().stream()
                .filter(item -> item.getId().equals(command.cartItemId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("CartItem not found"));
        shoppingCart.updateItemQuantity(itemToUpdate, command.newQuantity());
        shoppingCartRepository.save(shoppingCart);
    }


}