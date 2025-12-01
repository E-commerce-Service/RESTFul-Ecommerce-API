package org.wesley.ecommerce.application.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String PRODUCT_RATING_UPDATED_QUEUE = "product.rating.updated.queue";

    public static final String QUEUE_ORDER_PAYMENT_UPDATES = "order.payment.updates.queue";

    public static final String EXCHANGE_PAYMENT_EVENTS = "payment-events-exchange";

    public static final String QUEUE_PAYMENT_REQUEST = "payment_queue";


    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue productRatingUpdatedQueue() {
        return new Queue(PRODUCT_RATING_UPDATED_QUEUE);
    }

    @Bean
    public Queue orderPaymentUpdatesQueue() {
        return new Queue(QUEUE_ORDER_PAYMENT_UPDATES, true);
    }

    @Bean
    public TopicExchange paymentEventsExchange() {
        return new TopicExchange(EXCHANGE_PAYMENT_EVENTS);
    }

    @Bean
    public Binding bindingPaymentUpdates() {
        return BindingBuilder.bind(orderPaymentUpdatesQueue())
                .to(paymentEventsExchange())
                .with("payment.concluded.#");
    }
}