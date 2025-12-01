package org.wesley.ecommerce.application.api.v1.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import org.wesley.ecommerce.application.domain.enumeration.PaymentType;

public record CreateOrderRequest(
        @NotNull PaymentType paymentType,
        String cardToken
) {}