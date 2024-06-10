package com.event.wear.platform.rent.application.internal.commandservices;

import com.event.wear.platform.rent.domain.model.aggregates.ShoppingCart;
import com.event.wear.platform.rent.domain.model.valueobjects.PublicationId;
import com.event.wear.platform.rent.domain.model.valueobjects.UserId;
import com.event.wear.platform.rent.domain.model.commands.*;
import com.event.wear.platform.rent.domain.model.entities.CartItem;
import com.event.wear.platform.rent.domain.services.ShoppingCartCommandService;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.CartItemRepository;
import com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public CartItem handle(AddCartItemCommand command) {
        var cartItem = new CartItem(new UserId(command.userId()), new PublicationId(command.publicationId()), Math.toIntExact(command.quantity()));

        // Buscar si ya existe un ShoppingCart para este userId
        Optional<ShoppingCart> existingShoppingCart = shoppingCartRepository.findByUserId(command.userId());

        ShoppingCart shoppingCart;
        if (existingShoppingCart.isPresent()) {
            // Si existe, usar el ShoppingCart existente
            shoppingCart = existingShoppingCart.get();
        } else {
            // Si no existe, crear un nuevo ShoppingCart
            shoppingCart = new ShoppingCart();
            shoppingCart.setUserId(command.userId());
        }

        cartItem.setShoppingCart(shoppingCart);

        shoppingCartRepository.save(shoppingCart);
        cartItemRepository.save(cartItem); // Guardar el CartItem en la base de datos
        return cartItem;
    }

      @Override
    @Transactional
    public void handle(DeleteCartItemCommand command) {
        UserId userId = new UserId(command.userId());
        Long cartItemId = command.cartItemId();

        Optional<CartItem> existingCartItem = cartItemRepository.findByUserIdAndCartItemId(userId, cartItemId);

        if (!existingCartItem.isPresent()) {
            throw new IllegalArgumentException("CartItem not found");
        }

        cartItemRepository.delete(existingCartItem.get());
    }

    @Override
    @Transactional
    public Optional<ShoppingCart> handle(UpdateCartItemCommand command) {
        UserId userId = new UserId(command.userId());
        Optional<CartItem> existingCartItem = cartItemRepository.findByUserIdAndCartItemId(userId, command.Id());

        if (!existingCartItem.isPresent()) {
            throw new IllegalArgumentException("CartItem not found");
        }

        CartItem cartItem = existingCartItem.get();

        // Actualizar la cantidad del CartItem
        cartItem.setQuantity(command.newQuantity());

        // Guardar el CartItem actualizado
        cartItemRepository.save(cartItem);

        return Optional.of(cartItem.getShoppingCart());
    }

}