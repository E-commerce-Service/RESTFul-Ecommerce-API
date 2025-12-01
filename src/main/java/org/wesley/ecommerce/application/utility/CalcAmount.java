package org.wesley.ecommerce.application.utility;

import org.wesley.ecommerce.application.domain.enumeration.ItemStatus;
import org.wesley.ecommerce.application.domain.model.Cart;
import org.wesley.ecommerce.application.domain.model.CartItem;

import java.math.BigDecimal;

public class CalcAmount {
    public static void recalculateCartTotal(Cart cart) {
        BigDecimal newTotalPrice = cart.getItems().stream()
                .filter(item -> item.getStatus() == ItemStatus.PENDING)
                .map(CartItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        cart.setTotalPrice(newTotalPrice);
    }
}
