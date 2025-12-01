package org.wesley.ecommerce.application.api.v1.controller.dto.response;

import org.wesley.ecommerce.application.domain.model.OrderShopping;

import java.math.BigDecimal;
import java.util.List;

public record OrderHistoryResponse(
        Long orderId,
        String orderStatus,
        List<ItemResponse> items,
        BigDecimal totalPrice,
        String createdAt
) {

    public static OrderHistoryResponse fromDTO(OrderShopping orderShopping) {
        List<ItemResponse> itemResponses = orderShopping.getItems().stream()
                .map(OrderShoppingResponse::toItemDTO)
                .toList();

        return new OrderHistoryResponse(
                orderShopping.getId(),
                orderShopping.getStatus().name(),
                itemResponses,
                itemResponses.stream()
                        .map(ItemResponse::price)
                        .reduce(BigDecimal.ZERO, BigDecimal::add),
                orderShopping.getCreatedAt().toString()
        );
    }
}
