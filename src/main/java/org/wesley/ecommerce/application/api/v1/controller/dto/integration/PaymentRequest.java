package org.wesley.ecommerce.application.api.v1.controller.dto.integration;

import org.wesley.ecommerce.application.domain.enumeration.PaymentType;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentRequest(
    UUID orderId,
    BigDecimal amount,
    PaymentType type,
    String customerId,
    String cardToken
) {
}