package org.wesley.ecommerce.application.api.v1.controller.dto.request;


import java.math.BigDecimal;

public record CreateProductRequest(
        String name,
        String description,
        Integer stock,
        String categoryName,
        BigDecimal price
) {
}
