package org.wesley.ecommerce.application.api.v1.controller.dto.integration;

import org.wesley.ecommerce.application.domain.enumeration.PaymentStatus;
import org.wesley.ecommerce.application.domain.enumeration.PaymentType;

import java.util.UUID;

public record PaymentConcludedEvent(
        UUID orderId,
        String transactionId,
        PaymentStatus status,
        String message
) {}