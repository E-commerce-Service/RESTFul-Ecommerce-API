package org.wesley.ecommerce.application.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.wesley.ecommerce.application.api.v1.controller.dto.integration.PaymentConcludedEvent;
import org.wesley.ecommerce.application.config.rabbitmq.RabbitMqConfig;
import org.wesley.ecommerce.application.service.implement.OrderServiceImplement;


@Slf4j
@Component
public class PaymentEventListener {

    private final OrderServiceImplement orderService;
    public PaymentEventListener(OrderServiceImplement orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE_ORDER_PAYMENT_UPDATES)
    public void onPaymentConcluded(PaymentConcludedEvent event) {
        try {
            orderService.updateOrderStatusFromPayment(event.orderId(), event.status());
        } catch (Exception e) {
            log.error("Erro crítico ao atualizar status do pedido após pagamento", e);
        }
    }
}