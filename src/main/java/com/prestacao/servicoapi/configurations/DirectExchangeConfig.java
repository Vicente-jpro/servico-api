package com.prestacao.servicoapi.configurations;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DirectExchangeConfig {

    private final AmqpAdmin amqpAdmin;

    @Value("${rabbitmq.direct.exchange}")
    private String DIRECT_EXCHANGE;

    @Value("${rabbitmq.queues.servico-pagamentos}")
    private String SERVICO_PAGAMENTOS_QUEUE;

    @Value("${rabbitmq.queues.direct-2}")
    private String DIRECT_QUEUE_2;

    @Value("${rabbitmq.direct.routing-key-servico-pagamentos")
    private String ROUTING_KEY_SERVICO_PAGAMENTOS;

    @Value("${rabbitmq.direct.routing-key-2}")
    private String ROUTING_KEY_2;

    public Queue createServicoPagamentosQueue1() {

        return new Queue(SERVICO_PAGAMENTOS_QUEUE, true, false, false);
    }

    public Queue createDirectQueue2() {
        return new Queue(DIRECT_QUEUE_2, true, false, false);
    }

    public DirectExchange createDirectExchange() {
        return new DirectExchange(DIRECT_EXCHANGE, true, false);
    }

    public Binding createDirectBinding1() {
        return BindingBuilder.bind(createServicoPagamentosQueue1())
                .to(createDirectExchange())
                .with(ROUTING_KEY_SERVICO_PAGAMENTOS);
    }

    public Binding createDirectBinding2() {
        return BindingBuilder.bind(createDirectQueue2())
                .to(createDirectExchange())
                .with(ROUTING_KEY_2);
    }

    @Bean
    public AmqpTemplate directExchange(
            ConnectionFactory connectionFactory, MessageConverter messageConverter) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        rabbitTemplate.setExchange(DIRECT_EXCHANGE);

        return rabbitTemplate;
    }

    @PostConstruct
    public void init() {

        amqpAdmin.declareQueue(createServicoPagamentosQueue1());
        amqpAdmin.declareQueue(createDirectQueue2());
        amqpAdmin.declareExchange(createDirectExchange());
        amqpAdmin.declareBinding(createDirectBinding1());
        amqpAdmin.declareBinding(createDirectBinding2());

    }

}
