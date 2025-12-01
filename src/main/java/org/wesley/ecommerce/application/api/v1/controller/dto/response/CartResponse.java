package org.wesley.ecommerce.application.api.v1.controller.dto.response;

import org.wesley.ecommerce.application.domain.model.Cart;
import org.wesley.ecommerce.application.domain.model.CartItem;
import org.wesley.ecommerce.application.domain.model.Users;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;


public record CartResponse(
        Long cartID,
        List<ItemResponse> items,
        BigDecimal totalPrice
) {

    public static CartResponse fromDTO(Cart cart) {
        return new CartResponse(
                cart.getId(),
                cart.getItems().stream()
                        .sorted(Comparator.comparing(CartItem::getCreatedAt, Comparator.nullsLast(Comparator.naturalOrder())).reversed())
                        .map(ItemResponse::fromDTO)
                        .toList(),
                cart.getTotalPrice()
        );
    }

    public Cart from() {
        var cart = new Cart();
        var user = new Users();
        cart.setUser(user);
        return cart;
    }
}
